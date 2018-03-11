package br.com.tique.controller;

import br.com.tique.controller.util.Util;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Carlos
 */
public class PrincipalCTR extends AnchorPane implements Initializable {

    @FXML
    private AnchorPane barraSuperior;

    @FXML
    private Label lblMin;

    @FXML
    private Label lblMax;

    @FXML
    private Label lblClose;

    private Stage stage;
    private double x = 0, y = 0;

    public PrincipalCTR() {
        try {
            FXMLLoader loader = new FXMLLoader(new URL("file:///" + new File("src/br/com/tique/view/views/principal-view.fxml").getAbsolutePath()));
            loader.setRoot((Object) this);
            loader.setController((Object) this);
            loader.load();

            Scene scene = new Scene(this);
            stage = new Stage(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();

            new Util().fadeIn((AnchorPane) this);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void botoesBarraSuperior(MouseEvent event) {
        if (event.getSource() == lblMin) {
            stage.setIconified(true);
        } else if (event.getSource() == lblMax) {
            maxMin();
        } else if (event.getSource() == lblClose) {
            fechar();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mobility();
    }

    private void maxMin() {

        if (stage.isMaximized()) {
            stage.setMaximized(false);

        } else {
            stage.setMaximized(true);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Rectangle r = ge.getMaximumWindowBounds();
            stage.setHeight(r.height);
            stage.setWidth(r.width);
        }
    }

    private void fechar() {
        AnchorPane pane = (AnchorPane) stage.getScene().getRoot();
        new Util().fadeOut(pane, stage);
    }

    private void mobility() {
        barraSuperior.setOnMousePressed(e -> {
            x = stage.getX() - e.getScreenX();
            y = stage.getY() - e.getScreenY();
        });

        barraSuperior.setOnMouseDragged(e -> {
            if (!stage.isMaximized()) {
                stage.setX(e.getScreenX() + x);
                stage.setY(e.getScreenY() + y);
            }
        });
    }
}
