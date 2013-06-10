/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kolo
 */
public class MainWinController implements Initializable {

    @FXML
    private ListView<String> hotelList;
    @FXML
    private TextField placeTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> items = hotelList.getItems();
        //TODO get items from external database
        items.add("One");
        items.add("Two");
        items.add("Three");
        items.add("Four");
        items.add("Five");
    }

    @FXML
    private void handleSearchButtonAction() {
        System.out.println("Search Action");

        try {
            String cmd;
            cmd = "perl C:\\Users\\Kolo\\Documents\\SIApp\\src\\javafxapplication1\\scripts\\getHotelList\\nocowanie.pl ";
            Process proc = Runtime.getRuntime().
                    exec(cmd.concat(placeTextField.getText()));
            proc.waitFor();
            if (proc.exitValue() == 0) {
                System.out.print("Success!");
            } else {
                System.out.print("Error!");
            }
        } catch (IOException | InterruptedException exception) {
            System.out.printf(exception.getStackTrace().toString());
        }
    }

    @FXML
    private void handleViewListPickAction() {
        System.out.println(hotelList.getFocusModel().getFocusedItem());
    }
}
