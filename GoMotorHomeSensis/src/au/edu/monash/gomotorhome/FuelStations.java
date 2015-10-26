/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.io.InputStream;

import java.util.List;
import java.util.*;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Alhuthaif
 */
public class FuelStations {
    private static final String API_KEY = "yskawt7yc5ssu729zra8a8yq"; // TODO: put your API key here

   public List<Hashtable> getFuelstationData(String query, String location) throws Exception{
        List<Hashtable> fuelStations = new ArrayList<Hashtable>();
        Hashtable station;
        
        // construct url for the search endpoint
        URL searchUrl = new URL("http://api.sensis.com.au/v1/test/search?key=" + API_KEY
                 + "&query="
                 + URLEncoder.encode(query, "UTF-8")
                 + "&location="
                 + URLEncoder.encode(location, "UTF-8"));
        
        // open connection to the server
        HttpURLConnection conn = (HttpURLConnection)searchUrl.openConnection();
        conn.connect();
        
        
        try {
        
            // ensure HTTP 200 (OK) response
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException(
                        "Error calling Search API (HTTP status "
                        + conn.getResponseCode() + ")");
            }
            
            // grab the response stream
            InputStream stream = conn.getInputStream();
            
            // parse JSON response
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readValue(stream, JsonNode.class);
      
            // grab the reponse code and message
            int code = root.get("code").getIntValue();
            String message = root.get("message").getTextValue();

            // ensure successful status code
            switch (code) {
                case 200: // success
                    break;
                case 206: // spell-checker was run 
                    System.out.println("Note: " + message);
                    break;
                default:
                    throw new RuntimeException(
                            "API returned error: " + message + ", code: " + code);
            } 
            //System.out.println("All records: \r\n" + root.get("results"));
            //System.out.println("Total results found: " + root.get("totalResults").getIntValue());
            //Start Putting Data
            // iterate over the results
            for (JsonNode result : root.get("results")) {
                // fill up hashtable
               station = new Hashtable();               
                String name = result.path("name").getTextValue();
                String addressLine = result.path("primaryAddress").path("addressLine").getTextValue();
                String suburb = result.path("primaryAddress").path("suburb").getTextValue();
                String state = result.path("primaryAddress").path("state").getTextValue();
                String postcode = result.path("primaryAddress").path("postcode").getTextValue();
                addressLine = addressLine + ", " + suburb + " " + state + " " + postcode; 
                String latitude = result.path("primaryAddress").path("latitude").getTextValue();
                String longitude = result.path("primaryAddress").path("longitude").getTextValue();
                
                station.put("name", name);
                station.put("address", addressLine);
                station.put("lat", latitude);
                station.put("lon", longitude);
                fuelStations.add(station);
                
            }
//            System.out.println("Rec1: " + fuelStations.get(1).get("name"));
//            System.out.println("Rec4: " + fuelStations.get(4).get("name"));
            try {stream.close();}catch(Exception ex1){;}
            
            
        }
        catch(Exception ex5){;}
        finally {
            try {conn.disconnect();}catch(Exception ex2){;}
             // ensure we always close the connection
        }
        return fuelStations;
    }   
   
}
