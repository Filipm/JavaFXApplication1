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

//        GridPane grid = new GridPane();
//        grid.setAlignment(Pos.CENTER);
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setPadding(new Insets(25, 25, 25, 25));
//
//        Scene scene = new Scene(grid, 300, 250);
//
//        Text scenetitle = new Text("Witam");
//        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//        grid.add(scenetitle, 0, 0, 2, 1);
//
//        Label place = new Label("Miejscowość:");
//        grid.add(place, 0, 1);
//
//        final TextField placeTextField = new TextField();
//        grid.add(placeTextField, 1, 1);
//
//        Button btn = new Button("Search");
//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtn.getChildren().add(btn);
//        grid.add(hbBtn, 1, 2);
//
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                try {
//                    String cmd = "perl D:\\Linux\\test.pl ";
//                    System.out.println(placeTextField.getText());
//                    Process proc = Runtime.getRuntime().
//                            exec(cmd.concat(placeTextField.getText()));
//                    proc.waitFor();
//                    if (proc.exitValue() == 0) {
//                        System.out.print("Success!");
//                    } else {
//                        System.out.print("Error!");
//                    }
//                } catch (IOException | InterruptedException exception) {
//                    System.out.printf(exception.getStackTrace().toString());
//                }
//            }
//        });

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
