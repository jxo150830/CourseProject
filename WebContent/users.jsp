<%@ page import="stuff.Customer" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="style/main.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<title>Users</title>
	</head>
	<body>
		<%@ include file="navigation/sidebar.jsp" %>
		<div id="content-container">
			<div id="welcome-container">
				<h1 id="welcome-title">Users</h1>
				<p id="welcome-subtitle">[ subtitle goes here ]</p>
			</div>
			<div id="user-select-container">
				<ul>
					<% List<Customer> customers = (List<Customer>) request.getAttribute("customer_list"); %>
					<% for (Customer c : customers ) { %>
						<% if (c.getIsEnterprise() == 1) { %>
							<li><a class="section-header" href="profile?id=<%= c.getId() %>" style="background: #<%= c.getColor() %>;">Enterprise - <%= c.getName() %></a></li>
						<% } else if (!c.getName().equals("")) { %>
							<li><a class="section-header" href="profile?id=<%= c.getId() %>" style="background: #<%= c.getColor() %>;">Level <%= c.getLevel() %> - <%= c.getName() %></a></li>
						<% } else { %>
							<li><a class="section-header" href="profile?id=<%= c.getId() %>" style="background: #<%= c.getColor() %>;">Level <%= c.getLevel() %> - <%= c.getUsername() %></a></li>
						<% } %>
					<% } %>
				</ul>
			</div>
		</div>
	</body>
</html>