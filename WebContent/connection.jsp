<%@ page import="db.DbManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="style/connection.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<title>Connection</title>
	</head>
	<body>
		<p id="status-message">
			<%-- out.print("Hello. The date is " + new java.util.Date() + "."); --%>
			<%
				DbManager db = new DbManager();
				Connection conn = (Connection) db.getConnection();
				if(conn == null)
					out.print("Connection failed.");
				else
					out.print("Connection succeeded.");
			%>
		</p>
	</body>
</html>