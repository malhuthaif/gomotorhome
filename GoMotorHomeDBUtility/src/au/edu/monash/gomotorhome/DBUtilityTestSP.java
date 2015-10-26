/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome;

import au.edu.monash.gomotorhome.DBUtility;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Alhuthaif
 */
public class DBUtilityTestSP {

    /**
     * @param args the command line arguments
     */
    public static void main1(String[] args) throws SQLException{
    List<Hashtable> stationsData = new ArrayList<Hashtable>();
    List<Hashtable> wifiData = new ArrayList<Hashtable>();
    Hashtable hashdata = new Hashtable();
      
      hashdata.put("state","VIC");
      hashdata.put("town_name","Ararat");
      hashdata.put("casual_park","CP 1");
      hashdata.put("short_park","STP 1");
      hashdata.put("long_park","LTP 1");
      hashdata.put("dump_point","DP 1");
      hashdata.put("portable_water","PW 1");
      hashdata.put("lat","-111");
      hashdata.put("lon","222");
      hashdata.put("address","312 Sebastopol St, Ararat VIC 3333 ");
    
        DBUtility utility = new DBUtility();
        Vector messageTables = utility.updateSystemData(hashdata);
        //for(int i=0;i<messageTables.size();i++){
            //Hashtable messageTable = messageTables.get(i);
            Enumeration e  = messageTables.elements();
             while(e.hasMoreElements()){
                System.out.println(e.nextElement());
             }
        //}
    }
    public static void main(String[] args) throws SQLException{
    List<Hashtable> stationsData = new ArrayList<Hashtable>();
    List<Hashtable> wifiData = new ArrayList<Hashtable>();
    Hashtable hashdata = new Hashtable();
      
      hashdata.put("type","wifi");
      hashdata.put("state","VIC");
      hashdata.put("town_name","Ararat");
    
        DBUtility utility = new DBUtility();
        Vector messageTables = utility.importOtherLocationsData(hashdata.get("type").toString(), hashdata.get("town_name").toString(), hashdata.get("state").toString());
            Enumeration e  = messageTables.elements();
             while(e.hasMoreElements()){
                System.out.println(e.nextElement());
             }
    }
}
