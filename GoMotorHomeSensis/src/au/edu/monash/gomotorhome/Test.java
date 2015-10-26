/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Alhuthaif
 */
public class Test {
 public static void main(String[] args) throws Exception {
        List<Hashtable> stations = new ArrayList<Hashtable>();
        Hashtable station;
        stations = new FuelStations().getFuelstationData("fuel station", "ararat, vic");
        for (int i=0;i<stations.size();i++){
            station = stations.get(i);
            System.out.println("Record # : "+i);
            System.out.println("Name: "+station.get("name"));
            System.out.println("add: "+station.get("address"));
            System.out.println("lat: "+station.get("lat"));
            System.out.println("lon: "+station.get("lon"));
        }
    }    
}
