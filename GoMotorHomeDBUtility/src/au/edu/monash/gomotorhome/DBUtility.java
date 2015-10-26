/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Alhuthaif
 */
public class DBUtility extends DBInfo {

private ResultSet getResultSet(String query) throws SQLException{

st = con.createStatement();
sql = query;
ResultSet _rs = st.executeQuery(sql);
return _rs;
}
public Vector updateOtherLocationsData(List<Hashtable> otherLocationsData, String type, String town, String state)throws Exception{
    Vector messagesVectors = new Vector();
        
    Hashtable station = new Hashtable();

        for (int i=0;i<otherLocationsData.size();i++){
            station = otherLocationsData.get(i);

            Thread.sleep(500);
    try {
        pstmt = con.prepareStatement("{call staging.sp_update_other_locations_data(?,?,?,?,?,?,?)}");
        pstmt.setObject(1,  type);
        pstmt.setObject(2,  town);
        pstmt.setObject(3,  station.get("name"));
        pstmt.setObject(4,  station.get("address"));     
        pstmt.setObject(5,  station.get("lat"));     
        pstmt.setObject(6,  station.get("lon"));     
        pstmt.setObject(7,  state);
     
       rs = pstmt.executeQuery();
       while(rs.next()) {
           messagesVectors.addElement(rs.getString("message_desc"));
       }
    }
    catch(Exception ex){
        System.out.println("Error: "+ex.getMessage());
    }
        }
    return messagesVectors;
}
public Vector importOtherLocationsData(String type, String town, String state) {
    Vector messagesVectors = new Vector();

    try {
        pstmt = con.prepareStatement("{call staging.sp_import_other_locations_data(?,?,?)}");
        pstmt.setObject(1,  type);
        pstmt.setObject(2,  town);  
        pstmt.setObject(3,  state);
     
       rs = pstmt.executeQuery();
       while(rs.next()) {
           messagesVectors.addElement(rs.getString("message_desc"));
       }
    }
    catch(Exception ex){
        System.out.println("Error: "+ex.getMessage());
    }
    return messagesVectors;
}
public Vector updateSystemData(Hashtable featuresTownData) {
    Vector messagesVectors = new Vector();
    //Hashtable hashtable = new Hashtable();
    try {
        pstmt = con.prepareStatement("{call staging.sp_update_town_data(?,?,?,?,?,?,?,?,?,?)}");
        pstmt.setObject(1,  featuresTownData.get("town_name"));
        pstmt.setObject(2,  featuresTownData.get("state"));
        pstmt.setObject(3,  featuresTownData.get("casual_park"));
        pstmt.setObject(4,  featuresTownData.get("long_park"));     
        pstmt.setObject(5,  featuresTownData.get("short_park"));     
        pstmt.setObject(6,  featuresTownData.get("portable_water"));     
        pstmt.setObject(7,  featuresTownData.get("dump_point"));     
        pstmt.setObject(8,  featuresTownData.get("lat"));     
        pstmt.setObject(9,  featuresTownData.get("lon"));     
        pstmt.setObject(10, featuresTownData.get("address"));          
     
       rs = pstmt.executeQuery();
       int i=0;
       while(rs.next()) {
           messagesVectors.addElement(rs.getString("message_desc"));
       }
    }
    catch(Exception ex){
        System.out.println("Error: "+ex.getMessage());
    }
     
    return messagesVectors;
}
public List<Hashtable> GetData(String query){
    List<Hashtable> hashTables = new ArrayList<Hashtable>();
    Hashtable hashtable = new Hashtable();
String data="";
try {
st = con.createStatement();
rs = getResultSet(query);
rsMetaData = rs.getMetaData();
columnCount = rsMetaData.getColumnCount();
String colValue="";
String colName="";
if(rs.next()) {     
    hashtable = new Hashtable();
    for (int i=1; i<=columnCount; i++ ){
        if(rsMetaData.getColumnName(i)==null){
            colName=String.valueOf(i);
        }
        else{
            colName=rsMetaData.getColumnName(i).toString();
        }
        if(rs.getString(i)==null){
            colValue="";
        }
        else{
            colValue=rs.getString(i).toString();
        }
        hashtable.put(colName, colValue);
    }
    hashTables.add(hashtable);
}
}
catch(Exception ex){
    System.out.println(ex.toString());
}
return hashTables;
}    
}
