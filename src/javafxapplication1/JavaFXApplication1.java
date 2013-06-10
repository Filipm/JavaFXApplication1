/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import com.sun.javaws.Main;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Kolo
 */
public class JavaFXApplication1 extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            Pane page;
            page = (Pane) FXMLLoader.load(JavaFXApplication1.class.getResource("MainWin.fxml"));
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Accommodation Finder App");
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(JavaFXApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
