package br.com.tique.controller.util;

import javafx.animation.FadeTransition;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Carlos
 */
public class Util {

    public void fadeIn(AnchorPane pane) {
        FadeTransition ft = new FadeTransition(Duration.millis(400), pane);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    public void fadeOut(AnchorPane pane, Stage stage) {
        FadeTransition ft = new FadeTransition(Duration.millis(350), pane);
        ft.setToValue(0);
        ft.setOnFinished(e -> stage.close());
        ft.play();
    }
}
