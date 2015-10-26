/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome.geocoder;

import au.edu.monash.gomotorhome.geocoder.ApiKey;
import au.edu.monash.gomotorhome.geocoder.GeoAddress;
import java.io.*;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Alhuthaif
 */
public class Test {
    public static void main(String[] args)throws Exception{
        String key =(new ApiKey()).getApiKey();
        GeoAddress sample = new GeoAddress(key);
        System.out.println(sample.getAddress("Ararat", "VIC","-37.2821880", "142.9297500"));
        
    }
}
