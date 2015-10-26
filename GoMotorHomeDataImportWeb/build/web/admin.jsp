<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <html>
  <head>
  <meta charset="utf-8">
          <script src="js/jquery.min.js"></script>
          <script src="js/skel.min.js"></script>
          <script src="js/skel-layers.min.js"></script>
          <script src="js/init.js"></script>
          <noscript>
              <link rel="stylesheet" href="css/skel.css" />
              <link rel="stylesheet" href="css/style.css" />
              <link rel="stylesheet" href="css/style-xlarge.css" />
              <link href="css/bootstrap.css" rel="stylesheet"/>
          </noscript>
  <title>Data Import Automation</title>
  </head>
    <header id="header">
    <h1>
			<a href="index.html" class="logo"><img src='images/logo.png'></a>
		</h1>
    <nav id="nav">
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="aboutus.html">About Us</a></li>
        <li><a href="help.html">Help</a></li>
        <li><a href="contact.html">Contact Us</a></li>
      </ul>
     </nav>
 </header>  
              <body>
              <p id="aboutus">Data Import Automation</p>  

<form action="results.jsp" method="POST">
<table align=center width="50%" cellpadding="0" cellspacing="0" border="1">
<tr>
<td align=right width="300"><b>RV Friendly Town:</b></td><td width="300"><input STYLE="background-color: white;" type="text" name="townname"></td>
</tr>

<tr>
<td align=right width="300"><b>State:</b></td><td width="300">
  <select name="statename">
    <option value="VIC">Choose State</option>
	<option value="VIC">VIC</option>
    <option value="NSW">NSW</option>
    <option value="QLD">QLD</option>
	<option value="SA">SA</option>
	<option value="WA">WA</option>
	<option value="TAS">TAS</option>
  </select>
</td>
</tr>

<tr>
<td colspan=2 align=center width="500"><input type="submit" value="Submit"></td>
</tr>

</table>
  
<hr color="#000000" />
  <center>
  <hr color="#000000" />
  </center>
</form>


    <footer>
              <div>
                  <div>
                          <table class="copyright" width="100%">
						  <tr>
						  <td>&copy; Monash University IE Project. All rights reserved.</td>
						  <td align=right><a href="https://twitter.com/GoMotorHome2015" target="_blank"><img src="images\social\tw.jpg" height=50 width=50 /></a><a href="https://www.facebook.com/go.motorhome.5" target="_blank"><img src="images\social\fb.jpg" height=50 width=50 /></a><a href="https://www.linkedin.com/grp/home?gid=7010766" target="_blank"><img src="images\social\li.jpg" height=50 width=50 /></a><a href="https://plus.google.com/communities/117566559204031270067" target="_blank"><img src="images\social\gp.jpg" height=50 width=50 /></a><a href="https://www.youtube.com/channel/UCAp4OscM9i586t6vr708geg" target="_blank"><img src="images\social\ut.jpg" height=50 width=50 /></a>&nbsp;&nbsp;</td>
						  </tr>
						  </table>
                  </div>
              </div>
          </footer>
  </body>
  </html>
