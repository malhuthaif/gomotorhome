/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class DataImport {
    public DataImport(){
    
    }
    public Vector startImportProcess(String town, String state) throws Exception{
        String yello_pages_query=town+", "+state;
        Vector messageVectors = new Vector();
        Vector rvMessageTables = new Vector();
        Vector stationsMessageTables = new Vector();
        Vector wifiMessageTables = new Vector();
        List<Hashtable> wifiData = new ArrayList<Hashtable>();
           RVFriendlyData data = new RVFriendlyData();
           Hashtable rvFriendlyData = data.GetFriendlyData(town, state);
           Thread.sleep(2000);
           DBUtility utility = new DBUtility();
        List<Hashtable> stations = new FuelStations().getFuelstationData("Fuel Stations", yello_pages_query);

           if(rvFriendlyData.isEmpty() || rvFriendlyData.get("rvstatus").toString()!="OK"){
               stationsMessageTables.add(0, "No Data found for this RV Town "+town);
           }
           //else {                
                if(rvFriendlyData.get("rvstatus").toString()=="OK"){
                    rvMessageTables = utility.updateSystemData(rvFriendlyData);
                    Thread.sleep(2000);
                }
                else{
                    rvMessageTables.addElement("<b>Updating RV Friendly Town Data.</b>");
                    rvMessageTables.addElement("<font color='RED'>&nbsp;&nbsp;No RV Friendly Town Data found.</font>");
                }
                messageVectors.addAll(rvMessageTables);
                messageVectors.addElement("<b>Updating Fuel Stations Data.</b>");
                stationsMessageTables = utility.updateOtherLocationsData(stations, "fuel_station", town, state);
                Thread.sleep(2000);
                if(stationsMessageTables.isEmpty())
                    stationsMessageTables.addElement("<font color='RED'>&nbsp;&nbsp;No data found.</font>");
                messageVectors.addAll(stationsMessageTables);
                messageVectors.addElement("<b>Updating Wifi Points Data.</b>");
                wifiMessageTables = utility.importOtherLocationsData("wifi", town, state);
                if(wifiMessageTables.isEmpty())
                    wifiMessageTables.addElement("<font color='RED'>&nbsp;&nbsp;No data found.</font>");
                messageVectors.addAll(wifiMessageTables);

           return messageVectors;
    }
}
        