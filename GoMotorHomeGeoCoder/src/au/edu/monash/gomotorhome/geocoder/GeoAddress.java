/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome.geocoder;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Alhuthaif
 */
public class GeoAddress {
    public GeoAddress(){
        
    }
    public GeoAddress(String key){
        this.KEY=key;
    }
private String KEY="AIzaSyCyEgEnA_Ideu9Yd0YwnCROCXHd1mlGGI4";
    /**
     * @param args the command line arguments
     */ 
    public String getAddress(String town, String state, String lat, String lon){
    String address="";
    try {
            //Document doc = Jsoup.connect("https://maps.googleapis.com/maps/api/geocode/xml?address=vic%20australia&bounds=-36.11282,146.85936&key=AIzaSyCyEgEnA_Ideu9Yd0YwnCROCXHd1mlGGI4").get();
            Document doc = Jsoup.connect("https://maps.googleapis.com/maps/api/geocode/xml?address="+town+"%20"+state+"&bounds="+lat+","+lon+"&key="+KEY).get();
            org.jsoup.select.Elements links = doc.select("formatted_address");
            //Element e =links.first();
            //for(Element e: links)
            //{
            if(!links.isEmpty())
              address=links.first().text();
            //    System.out.println(e.text());
            //}
        } catch (IOException iOException) {
            System.out.println(iOException.getMessage());
                    
        }
    return address;
    }
    
    
}
