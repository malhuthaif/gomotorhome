/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome;

import au.edu.monash.gomotorhome.geocoder.ApiKey;
import au.edu.monash.gomotorhome.geocoder.GeoAddress;
import au.edu.monash.gomotorhome.DBUtility;
import java.util.Hashtable;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Alhuthaif
 */
public class RVFriendlyData {

    private String GetAddress(String town, String state, String lat, String lon ) throws Exception{
        String address="";
        String key =(new ApiKey()).getApiKey();
        GeoAddress sample = new GeoAddress(key);
        address = sample.getAddress(town,state,lat, lon);
        //System.out.println);
        return address;
    }
    
public Hashtable GetFriendlyData(String town,String state) throws Exception{
    String rv_id=""; 

        Hashtable hashdata = new Hashtable();
        
        hashdata.put("town_name", town);
        hashdata.put("state", state);
        
        String query="SELECT ifnull(rv_id,'') as rv_id FROM staging.post_codes where locality='"+town+"' and stateCodeID='"+state+"';";
        DBUtility utility = new DBUtility();
        List<Hashtable> Hashtables = utility.GetData(query);
        if(Hashtables.get(0) ==null || Hashtables.get(0).size()==0 || Hashtables.get(0).get("rv_id").equals(null) || Hashtables.get(0).get("rv_id").equals("")){
            hashdata.put("rvstatus", "RV Town Not Found..");
        }
        else {
            rv_id = Hashtables.get(0).get("rv_id").toString();
            hashdata.put("rvstatus", "OK");
     try {  
      String url = "https://www.cmca.net.au/services/rv-friendly/rv-friendly-towns/"+rv_id;

      System.setProperty("jsse.enableSNIExtension", "false");

      Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
      
      Elements metaElements = doc.getElementsByTag("meta");
      if(metaElements==null || metaElements.isEmpty()){
          hashdata.put("lat",0);
          hashdata.put("lon",0);
      }
      for(Element metaElement : metaElements) {
          if(metaElement.attr("name").equalsIgnoreCase("geo.position")){
               hashdata.put("lat",metaElement.attr("content").split(";")[0]);
               hashdata.put("lon",metaElement.attr("content").split(";")[1]);
          }
      }
      Element elementsByTag = doc.getElementsByTag("table").get(0);
       Elements rows = elementsByTag.getElementsByTag("tr");
       String td1="";
       String td2="";
      for(Element row : rows) {
          if(row.getElementsByTag("td").get(0)!=null)
            td1=row.getElementsByTag("td").get(0).text();
          
          if(row.getElementsByTag("td").get(1)!=null){
            td2=row.getElementsByTag("td").get(1).text();            
          }
          else{
            td2="";
          }
          if(td1==null)
            td1="";    
          td1 = td1.trim();
          if(td1.equalsIgnoreCase("Casual Parking"))
            hashdata.put("casual_park", td2);          
          else if(td1.equalsIgnoreCase("Short Term Parking"))
            hashdata.put("short_park", td2);
          else if(td1.equalsIgnoreCase("Long Term Parking"))
            hashdata.put("long_park", td2);
           else if(td1.equalsIgnoreCase("Dump Point"))
            hashdata.put("dump_point", td2);
          else if(td1.equalsIgnoreCase("Potable Water"))
              hashdata.put("portable_water", td2);
      }
      }
      catch(Exception ex){
          System.out.println("Error2: "+ex.toString());
      }
        String address = GetAddress(town, state,hashdata.get("lat").toString(), hashdata.get("lon").toString());
        hashdata.put("address", address);
     }
     return hashdata;
}
}
