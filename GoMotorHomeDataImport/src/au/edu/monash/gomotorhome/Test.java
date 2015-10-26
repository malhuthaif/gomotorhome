/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.monash.gomotorhome;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Alhuthaif
 */
public class Test {
        public static void main(String[] args)throws Exception{
     
       String town="Ararat";
       String state="VIC";
       DataImport dataImport = new DataImport();
       Vector messagesVector  = dataImport.startImportProcess(town, state);      
            Enumeration messagesEnum  = messagesVector.elements();
            //Iterator itr = c.iterator();
             while(messagesEnum.hasMoreElements()){
                System.out.println(messagesEnum.nextElement());
             }

    }
}
