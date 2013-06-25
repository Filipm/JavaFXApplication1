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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

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
    @FXML
    private Label hotelName;
    @FXML
    private Label hotelAddress;
    @FXML
    private Label hotelOcena;
    @FXML
    private GridPane opinionPane;

    private void getUrlToFile(String link, String file) {
        try {
            String cmd = "perl src\\javafxapplication1\\scripts\\getSite.pl " + link + " " + file;
            Process proc = Runtime.getRuntime().exec(cmd);
            proc.waitFor();
            if (proc.exitValue() == 0) {
                System.out.println("Getting " + link + " as a " + file + " file = Success!");
            } else {
                System.out.println("Getting " + link + " as a " + file + " file = Error!");
            }
        } catch (IOException | InterruptedException exception) {
            System.out.printf(exception.getStackTrace().toString());
        }
    }

    private void runScript(String site, String script, String arg) {
        try {
            String cmd = "perl src\\javafxapplication1\\scripts\\" + site + "\\" + script + ".pl " + arg + ".txt";
            Process proc = Runtime.getRuntime().exec(cmd);
            proc.waitFor();
            if (proc.exitValue() == 0) {
                System.out.println("Running script " + script + " for site " + site + " = Success!");
            } else {
                System.out.println("Running script " + script + " for site " + site + " = Error!");
            }
        } catch (IOException | InterruptedException exception) {
            System.out.printf(exception.getStackTrace().toString());
        }
    }

    //nocowanie.pl
    private void Nocowanie(String place) {
        String link = "http://www.nocowanie.pl/noclegi/" + place;
        String result = "nocowanie";
        getUrlToFile(link, result); //Zdobędzie stronę z hotelami dla danej miejscowości
        runScript("Nocowanie", "linki", result); //To zwróci linki
        //Przejdzie po wszystkich linkach i zdobędzie informacje o danym hotelu
        try {
            File file = new File("linki.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int num = 0;
            while ((line = br.readLine()) != null) {
                int mod = (num % 5);
                switch (mod) {
                    case 0:
                        HotelData data = new HotelData();
                        data.Link = line.trim();
                        hotelDataList.add(data);
                        //przejdź po linku do strony i wydobądź info o hotelu
                        result = "hotel";
                        getUrlToFile(data.Link, result);//To zwróci stronę z hotelem
                        runScript("Nocowanie", "hotel", result);//Zwróci info.txt
                        File info = new File("info.txt");
                        BufferedReader infoBr = new BufferedReader(new FileReader(info));
                        String str;
                        int l = 0;
                        while ((str = infoBr.readLine()) != null) {
                            if (l == 0) {
                                //przejdz do opinii, wczytaj je i zapisz do klasy
                                String opinie = str.trim();
                                String out = "opinie";
                                getUrlToFile(opinie, out); //To zwróci stronę z opiniami użytkowników
                                runScript("Nocowanie", "opinie", out); //Zwróci opinions.txt

                                File op = new File("opinions.txt");
                                BufferedReader opBr = new BufferedReader(new FileReader(op));
                                String str2;
                                while ((str2 = opBr.readLine()) != null) {
                                    if (str2.trim().compareTo("") != 0) {
                                        data.Opinie.add(str2.trim());
                                    }
                                }
                            } else if (l == 1) {
                                //wczytaj ocene //Do poprawy
                                data.Ocena = str.trim();
                            }
                            ++l;
                        }
                        break;
                    case 1:
                        hotelDataList.get(hotelDataList.size() - 1).Name = line.trim();
                        break;
                }
                ++num;
            }
            br.close();
        } catch (IOException exe) {
            System.out.printf(exe.getStackTrace().toString());
        }

        //Wpisz dane do widoku
        ObservableList<String> items = hotelList.getItems();
        items.clear();
        for (HotelData hd : hotelDataList) {
            items.add(hd.Name);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        hotelDataList = new ArrayList<HotelData>();

        ObservableList<String> items = hotelList.getItems();
        
        items.add("...");
        items.add("...");
        items.add("...");
        items.add("...");
        items.add("...");
    }

    @FXML
    private void handleSearchButtonAction() {
        System.out.println("Search Action");
        hotelDataList.clear();
        String place = placeTextField.getText();
        Nocowanie(place);
    }

    @FXML
    private void handleViewListPickAction() {
        System.out.println(hotelList.getFocusModel().getFocusedItem());
        String name = hotelList.getFocusModel().getFocusedItem();
        for (HotelData hotel : hotelDataList) {
            if (hotel.Name.equals(name)) {
                //Fill data TODO
                hotelName.setText(name);
                hotelOcena.setText(hotel.Ocena);
                
                //Uzupelnij opinie
            }
        }
    }
}
