/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome;

import au.edu.monash.gomotorhome.DBUtility;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Alhuthaif
 */
public class DBUtilityTestQuery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String query="SELECT * FROM staging.post_codes where locality='Ararat';";
        DBUtility utility = new DBUtility();
        List<Hashtable> Hashtables = utility.GetData(query);
        for(int i=0;i<Hashtables.size();i++){
            Hashtable hashtable = Hashtables.get(i);
             System.out.println(hashtable.get("locality").toString());
             System.out.println(hashtable.get("post_code").toString());
        }
    }
    
}
