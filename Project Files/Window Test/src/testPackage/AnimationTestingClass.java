/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPackage;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Phil Rey Paderogao
 */
public class AnimationTestingClass extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        FadeTransition fadeIn = new FadeTransition(Duration.millis(1500),btn);
        FadeTransition fadeOut = new FadeTransition(Duration.millis(1500),btn);
        
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                fadeIn.play();
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
