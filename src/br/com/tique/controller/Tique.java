
package br.com.tique.controller;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 */
public class Tique extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        PrincipalCTR pc = new PrincipalCTR();
    }
    
    public static void main(String []args){
        launch(args);
    }
}
