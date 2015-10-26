/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome.geocoder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Alhuthaif
 */
public class ApiKey {
    public String getApiKey()throws Exception{
   String key="";
        Properties prop = new Properties();
        
        InputStream input = null;
	try 
        {
            input = getClass().getResourceAsStream("geocoder.properties");
                    //new FileInputStream("geocoder.properties");
            prop.load(input);

		// set the properties value
		key = prop.getProperty("API_KEY");
        } 
        catch (Exception io) {
		io.printStackTrace();
	} 
        finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
        } 
        return key;
    }
}
