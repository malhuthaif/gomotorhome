/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome;


//import javax.lang.model.util.Elements;

//import au.edu.monash.gomotorhome.DBUtility;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;


/**
 *
 * @author Alhuthaif
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        String town="Ararat";
        String state="VIC";
        RVFriendlyData data = new RVFriendlyData();
        Hashtable hashdata = data.GetFriendlyData(town, state);
        
      System.out.println("Casual Parking: "+hashdata.get("casual_park"));
      System.out.println("Short Term Parking: "+hashdata.get("short_park"));
      System.out.println("Long Term Parking: "+hashdata.get("long_park"));
      System.out.println("Dump Point: "+hashdata.get("dump_point"));
      System.out.println("Portable Water: "+hashdata.get("portable_water"));
      System.out.println("Latitude: "+hashdata.get("lat"));
      System.out.println("Longitude: "+hashdata.get("lon"));
      System.out.println("Address: "+hashdata.get("address"));
    }
    
}
