package au.edu.monash.gomotorhome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBInfo {
    public String driver="com.mysql.jdbc.Driver";
    public String server="52.64.18.105";
    public String db="staging";
    public String port="3306";
    public String user="root";
    public String password="Redmouse@123";
    public Connection con;
    public Statement st;
    public PreparedStatement pstmt;
    public String sql;
    public ResultSet rs;
    public ResultSetMetaData rsMetaData;
    public int columnCount;
    public DBInfo() {
        try {
            Class.forName(driver).newInstance();
            this.con = DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+db+"?connectTimeout=90000&socketTimeout=90000", user, password);            
        }
        catch(Exception ex){;}
    }
    public void closeObjects(){
        try {
            this.con.close();
        }
        catch(Exception ex){;}
        try {
            this.rs.close();
        }
        catch(Exception ex){;}
    }
}