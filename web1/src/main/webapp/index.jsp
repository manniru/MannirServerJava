<%@include file="header.jsp" %>
<%@page import="java.io.File"%>


<%
//int os = System.getProperty("os.name").toLowerCase().indexOf("win")+1;
//if(os==1)



%>

<% 
//String loc = System.getProperty("user.dir")+"/"+"ebahniptv.properties";
//System.out.println(loc);
//File fl=new File(System.getProperty("user.dir")+"/"+"ebahniptv.properties");
//if (!fl.exists()) { response.sendRedirect("install.jsp"); }
//else { 
%><%//@include file="header.jsp" %><% // } %>

<%
/**
System.out.println(System.getProperty("user.dir"));

if(request.getParameter("login") != null) {
	String user="", pass="", user2="", pass2="", role="", role2="";
	user = request.getParameter("user");
	pass = request.getParameter("pass");
	role = request.getParameter("role");
	
	try { ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM _users WHERE role='"+role+"' AND username='"+user+"' AND password='"+pass+"'"); rs.next();
		user2 = rs.getString("username");
		pass2 = rs.getString("password");
		role2 = rs.getString("role");
	} catch(Exception e4) { System.out.println(e4); }
	
	if(user.equals(user2) && pass.equals(pass2) && !user.equals("") && !pass.equals("")) {
		session.setAttribute("username", user);
		session.setAttribute("password", pass);
		session.setAttribute("role", role);
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", role2+".jsp"); 
	}
	else { response.sendRedirect("index.jsp?msg=Invalid username or password!"); }
}
if(request.getParameter("q") != null && request.getParameter("q").equals("logout")) {
	session.setAttribute("username", null);
	session.setAttribute("password", null);
	session.setAttribute("role", null);
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
}



*/
%>

<td align="center" valign="top">
						<div id="main">
												<h1 class="title"></h1>
				<div class="tabs"></div>
												  <div class="node">
        <h2 class="title"><a href="/"></a></h2><div class="content">
        <p><center><strong><h1>eBahn IPTV Middleware Server</h1></strong></center>
      
        
        </p>
</div>


		<div id="fontimage">
     
        
        
        <table width="100%" border="0">
          <tr>
            <td><a href="/#"><img src="images/p0.png" alt="Picture 1" width="360" height="278" /></a></td>
            <td><a href="/#"><img src="images/iptv2.png" alt="Picture 1" width="400" height="300" /></a></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
		</div>
		
		
      </div>
				</div>
		</td>


		
		

		
			</tr>
</table></div>


<div id="footer-wrapper" class="clear-block">
	<div id="bar2"></div>
	<div id="footer">
	<div style="float:left"></div>
		
<div class="legal"> Copyright Ebahn Sdn Bhd, Malaysia <a href="http://mannir.net/">2014</a> <div id="brand"></div></div>
	</div>
	<div class="footer-right">
		<div class="footer-left">
		</div> <!-- /footer-left -->
	</div> <!-- /footer-right -->
</div> <!-- /footer-wrapper -->

<div id="shadow" class="clear-block">
	<div class="shadow-right">
		<div class="shadow-left">

		</div>
	</div>
</div>

</div>
</body>
</html>