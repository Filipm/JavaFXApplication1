/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;

/**
 * FXML Controller class
 *
 * @author Kolo
 */
public class MainWinController implements Initializable {

    @FXML private ListView<String> hotelList;
    
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
    }
    
    @FXML
    private void handleViewListPickAction() {        
        System.out.println(hotelList.getFocusModel().getFocusedItem());
    }
}
