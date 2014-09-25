<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<head>
<title>eBahn IPTV Central Server</title>
<link rel="alternate" type="application/rss+xml" title="Mannir eSystems Limited RSS" href="rss.xml">

<link rel="shortcut icon" href="files/favicon0.png" type="image/x-icon">
<link type="text/css" rel="stylesheet" media="all" href="files/node0000.css">
<link type="text/css" rel="stylesheet" media="all" href="files/defaults.css">
<link type="text/css" rel="stylesheet" media="all" href="files/system00.css">
<link type="text/css" rel="stylesheet" media="all" href="files/system-m.css">
<link type="text/css" rel="stylesheet" media="all" href="files/user0000.css">
<link type="text/css" rel="stylesheet" media="all" href="files/style000.css">
<link type="text/css" rel="stylesheet" media="all" href="ebahniptv.css">

<script type="text/javascript" src="files/jquery00.js"></script>
<script type="text/javascript" src="files/drupal00.js"></script>
<script type="text/javascript" src="files/jquery01.js"></script>
<script type="text/javascript" src="files/suckerfi.js"></script>
<script language="javascript" src="files/jquery-1.js"></script>
</head>
<body>
<div id="above" class="clear-block"></div>
<div id="page">
	<div id="masthead">

		<div id="header" class="clear-block">
			<div class="header-right">
				<div class="header-left">
					<div id="logo" style="text-align:left;"><a href="" title="Home"><img width="115" height="104" src="images/logo.png" alt="Home"></a></div> 
					<div id="name-and-slogan">
                    <h1 id="site-name" align="center">
							<a href="" title="Home">eBahn IPTV Central Server</a>
                            <div id="site-slogan" style="font-size:20px;">eBahn IPTV Central Server for Control Middleware and Setup Box</div>
						</h1><h2><center><%//= msg %></center></h2>
						</div> <!-- /name-and-slogan -->
                                                            
								</div>  <!-- /header-left -->
  			</div> <!-- /header-right -->
		</div> <!-- /header -->

	</div>

	<div id="prenav"></div>
	<div id="navigation" class="menu">
			<div id="primary" class="clear-block">	
			
<div class="navcont">
<%

out.println("<ul><li class='menu-114 first'><a href='index.jsp' title='Home'>Home</a></li>");
                            		
out.println(
//"<li class='menu'><a href='main.jsp' title='Main Menu'>Main</a></li>"+
"<li class='menu'><a href='admin.jsp'>Admin</a></li>"+
"<li class='menu'><a href='modules.jsp'>Modules</a></li>"+
//"<li class='menu'><a href='newstb.jsp'>Installation</a></li>"+
"<li class='menu'><a href='images.jsp'>Images</a></li>"+
"<li class='menu'><a href='stb.jsp'>Setupbox</a></li>"+
//"<li class='menu'><a href='adbcontrol.jsp'>Stb Control</a></li>"+
"<li class='menu'><a href='digitalsignage.jsp'>Digital Signage</a></li>"+
"<li class='menu'><a href='license.jsp'>License</a></li>"+
"<li class='menu-122'><a href='reports.jsp' title='Repors'>Reports</a></li>"+
"<li class='menu'><a href='settings.jsp'>Settings</a></li>"+
"<li class='menu'><a href='index.jsp?q=logout'>Logout</a></li>");
/**                           		
if(session.getAttribute("role")!=null && session.getAttribute("role").equals("admin")) {
out.println(
		//"<li class='menu'><a href='main.jsp' title='Main Menu'>Main</a></li>"+
		"<li class='menu'><a href='admin.jsp'>Admin</a></li>"+
		"<li class='menu'><a href='modules.jsp'>Modules</a></li>"+
		//"<li class='menu'><a href='newstb.jsp'>Installation</a></li>"+
		"<li class='menu'><a href='images.jsp'>Images</a></li>"+
		"<li class='menu'><a href='stb.jsp'>Setupbox</a></li>"+
		//"<li class='menu'><a href='adbcontrol.jsp'>Stb Control</a></li>"+
		"<li class='menu'><a href='digitalsignage.jsp'>Digital Signage</a></li>"+
		"<li class='menu'><a href='license.jsp'>License</a></li>"+
		"<li class='menu-122'><a href='reports.jsp' title='Repors'>Reports</a></li>"+
		"<li class='menu'><a href='settings.jsp'>Settings</a></li>"+
		"<li class='menu'><a href='index.jsp?q=logout'>Logout</a></li>");

out.println("<form method='post'>IP Address:");
String disabled = (session.getAttribute("ip")!=null) ? "disabled":"";
out.println("<select "+disabled+" name='ipaddress'>");
out.println("<option value='"+session.getAttribute("ip")+"' selected>"+session.getAttribute("ip")+"</option>");
try {
	ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM `_stb`");
	while(rs.next()) {
		String ip = rs.getString("ip");
		String roomno = rs.getString("roomno");
		String title = rs.getString("title");
		out.println("<option value='"+ip+"'>"+ip+"("+title+")</option>");
	}
} catch(Exception e2) { System.out.println(e2); }

out.println("</select>");
out.println("<input name='"+status1+"' type='submit' value='"+status1+"' />");
out.println("</form>");



}

if(session.getAttribute("role")!=null && session.getAttribute("role").equals("client")) {
	out.println(
			"<li class='menu'><a href='main.jsp' title='Main Menu'>Main</a></li>"+
			//"<li class='menu'><a href='newstb.jsp'>Installation</a></li>"+
			"<li class='menu'><a href='images.jsp'>Images</a></li>"+
			"<li class='menu'><a href='stb.jsp'>Setupbox</a></li>"+
			"<li class='menu'><a href='adbcontrol.jsp'>Stb Control</a></li>"+
			"<li class='menu'><a href='digitalsignage.jsp'>Digital Signage</a></li>"+
			"<li class='menu'><a href='settings.jsp'>Settings</a></li>"+
			"<li class='menu'><a href='help.jsp'>Help</a></li>"+
			"<li class='menu-122'><a href='reports.jsp' title='Repors'>Reports</a></li>"+
	"<li class='menu'><a href='index.jsp?q=logout'>Logout</a></li>");

	out.println("<form method='post'>IP Address:");
	out.println("<select name='ipaddress'>");
	out.println("<option value='"+session.getAttribute("ip")+"' selected>"+session.getAttribute("ip")+"</option>");
	try {
		ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM `_stb`");
		while(rs.next()) {
			String ip = rs.getString("ip");
			String roomno = rs.getString("roomno");
			String title = rs.getString("title");
			out.println("<option value='"+ip+"'>"+ip+"("+title+")</option>");
		}
	} catch(Exception e2) { System.out.println(e2); }

	out.println("</select>");
	out.println("<input name='"+status1+"' type='submit' value='"+status1+"' />");
	out.println("</form>");
}
out.println("</ul>");
*/
%>

</div>



		</div>
			</div>	<div id="postnav"></div>

	


<div id="middlecontainer">
<table border="0" cellpadding="0" cellspacing="0" id="content"><tr>


<td id="sidebar-left"><div class='block block-user' id='block-user-0'>
<% // MENUS

int uid=1;

if(session.getAttribute("username")==null) {
out.println("<h2 class='title'>User login</h2><div class='content'><form action='' method='post' id='loginform'>"+
		"<div class='form-item'><label>Select Server</label><select name='role'><option value='admin'>Central Server</option><option value='client'>Client Server</option></select></div>"+
		"<div class='form-item'><label>Username</label><input type='text' name='user' id='user' size='11'/></div>"+
		"<div class='form-item'><label>Password</label><input type='password' name='pass' id='pass' size='11'/></div>"+
		"<input type='submit' name='login' id='login' value='Log in'  class='form-submit' />"+
		//"<div class='item-list'><ul><li class='first'><a href='appedit.jsp'>New Applicaton</a></li>"+
		//"<li><a href='regedit.jsp'>New Registration</a></li><li class='last'><a href='#'>Forgot Password</a></li>"+
		"</ul></div></form></div>");
}

%>


 
</td>