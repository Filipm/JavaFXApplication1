/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.ArrayList;

/**
 *
 * @author Kolo
 */
public class HotelData {

    public HotelData() {
        Opinie = new ArrayList<String>();
    }
    
    public String Name;
    public String Link;
    public String Ocena;
    public ArrayList<String> Opinie;
}
