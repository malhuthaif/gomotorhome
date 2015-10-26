/*
 * This is the project to test WiFi Data.
 */
package au.edu.monash.gomotorhome;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Test {
    /*
     This is the class to Test WiFiData.
    */
    public static void main(String[] args) throws Exception{
        String town="Ararat";
        String state="VIC";
        WiFiData data = new WiFiData();
        List<Hashtable> hashdata = data.GetWiFiData(town, state);        
        for(int i=0;i<hashdata.size();i++){
            Hashtable hashtable = hashdata.get(i);
            System.out.println("Wifi Point: "   +hashtable.get("name"));
            System.out.println("Address: "      +hashtable.get("address"));            
            System.out.println("Latitude: "     +hashtable.get("lat"));
            System.out.println("Longitude: "    +hashtable.get("lon"));
        }
    }    
}