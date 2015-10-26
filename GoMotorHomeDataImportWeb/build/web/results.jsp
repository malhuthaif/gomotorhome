<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <title>Data Import Automation</title>
      <header id="header">
    <h1>
			<a href="index.html" class="logo"><img src='images/logo.png'></a>
		</h1>
      </header>
  <%@page import="java.util.*"%>
  <%@page import="java.sql.*"%>
  <%@page import="au.edu.monash.gomotorhome.*"%>
  <table cellpadding=1 cellspacing=1 border=0>  

<%   String sql="";
     String str1="";
     String str2="";
     String str3="";
     int count_results=0;
     String texttownname="";
     String textstatename="";
	 String message="";
     String dateto="";
     String texttosearchwhere="";
     String datefromwhere="";
     String datetowhere="";
     String final_where="";
     int total_results=0;
     String results_message="";
        if(request.getParameter("townname")!=null){
	        texttownname=request.getParameter("townname");
		    System.out.println("RV Friendly Town: "+texttownname);
	   }        
        if(request.getParameter("statename")!=null) {
        	textstatename=request.getParameter("statename");
        	System.out.println("datefrom: "+textstatename);
        }

	    if(texttownname == null || texttownname == "" || textstatename == null || textstatename == ""){
			message = "Either RV Town or State is not given, Data Import process aborted..";			
		}
		else {
			message = "Data Import process completed for : "+texttownname+"("+textstatename+")";
	   au.edu.monash.gomotorhome.DataImport dImport = new au.edu.monash.gomotorhome.DataImport();
       Vector messagesVector  = dImport.startImportProcess(texttownname, textstatename);      
            Enumeration messagesEnum  = messagesVector.elements();
%>			
	<tr><td colspan=2><b><font color="#3366cc">Data Import process, started plz wait...</b></font></</td></tr>
<%	
             while(messagesEnum.hasMoreElements()){
%>
<tr><td colspan=2>&nbsp;<%= messagesEnum.nextElement() %></</td></tr>

<%
			 }
		}
%>
</table>
  </head>
  <body>
  <hr color="#000000" />
  <center>
  <h2><font color="#3366cc"><%= message%></font></h2>
  <h3><font color="#0000ff"><%= new java.util.Date() %> </font></h3>
  <hr color="#000000" />
  </center>
  </body>
  </html>
