/*
  This is the project to test WiFi Data.
 */
package au.edu.monash.gomotorhome;
import au.edu.monash.gomotorhome.DBUtility;
import java.util.Hashtable;
import java.util.List;
/**
 * @author Alhuthaif
 */
public class WiFiData {    
public List<Hashtable> GetWiFiData(String town,String state) throws Exception{
        String query="select * from staging.other_raw where town_name='"+town+"' and state='"+state+"' and type='wifi'";
        DBUtility utility = new DBUtility();
        List<Hashtable> hashdata = utility.GetData(query);
     return hashdata;
}
}
