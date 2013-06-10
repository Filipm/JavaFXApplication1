/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    private ArrayList<HotelData> hotelDataList;
    @FXML
    private ListView<String> hotelList;
    @FXML
    private TextField placeTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        hotelDataList = new ArrayList<HotelData>();

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

        String place = placeTextField.getText();
        //First Step
        try {
            //get Hotels in the area
            String cmd;
            cmd = "perl C:\\Users\\Kolo\\Documents\\SIApp\\src\\javafxapplication1\\scripts\\getHotelList\\nocowanie.pl ";
            Process proc = Runtime.getRuntime().
                    exec(cmd.concat(place));
            proc.waitFor();
            if (proc.exitValue() == 0) {
                System.out.println("Success!");
            } else {
                System.out.println("Error!");
            }
        } catch (IOException | InterruptedException exception) {
            System.out.printf(exception.getStackTrace().toString());
        }

        //Second Step
        try {
            //getAllHotelsAndLinks
            String pathToScript;
            String pathToTxt;
            pathToScript = "C:\\Users\\Kolo\\Documents\\SIApp\\src\\javafxapplication1\\scripts\\linki.pl";
            pathToTxt = "C:\\Users\\Kolo\\Documents\\SIApp\\nocowanie_" + place + ".txt";
            String cmd = "perl " + pathToScript + " " + pathToTxt;

            Process proc = Runtime.getRuntime().exec(cmd);
            proc.waitFor();
            if (proc.exitValue() == 0) {
                System.out.println("Success!");
            } else {
                System.out.println("Error!");
            }
        } catch (IOException | InterruptedException exception) {
            System.out.printf(exception.getStackTrace().toString());
        }

        //Third Step
        try {
            File file = new File("C:\\Users\\Kolo\\Documents\\SIApp\\result.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            HotelData data;
            while ((line = br.readLine()) != null) {
                data = new HotelData();
                data.Link = line.trim();

                try {
                    line = br.readLine();
                } catch (IOException exe) {
                    System.out.printf(exe.getStackTrace().toString());
                }
                data.Name = line.trim();
                hotelDataList.add(data);

                try {
                    if ((line = br.readLine()) == null) {
                        break;
                    }
                    if ((line = br.readLine()) == null) {
                        break;
                    }
                } catch (IOException exe) {
                    System.out.printf(exe.getStackTrace().toString());
                }
            }
            br.close();
        } catch (IOException exe2) {
            System.out.printf(exe2.getStackTrace().toString());
        }

        ObservableList<String> items = hotelList.getItems();
        items.clear();
        for (HotelData hd : hotelDataList) {
            items.add(hd.Name);
        }
    }

    @FXML
    private void handleViewListPickAction() {
        System.out.println(hotelList.getFocusModel().getFocusedItem());
    }
}
