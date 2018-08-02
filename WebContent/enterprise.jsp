<%@ page import="stuff.Customer" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="script/enterprise.js"></script>
		<link rel="stylesheet" href="style/main.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<title>Enterprise</title>
	</head>
	<body>
		<%@ include file="navigation/sidebar.jsp" %>
		<div id="content-container">
			<div id="welcome-container">
				<h1 id="welcome-title">Enterprise</h1>
				<p id="welcome-subtitle">[ subtitle goes here ]</p>
			</div>
			<div id="notice-container" ${notice_display}>${notice}</div>
			<form class="section-container" id="enterprise-form" name="enterprise-form" action="enterprise" method="post" onsubmit="return enterpriseValidate()">
				<p>
					Create <input class="input-box" id="amount" type="text" name="amount"> new account(s).
					<input class="input-box input-button" id="submit" type="submit" name="submit" value="Submit">
					<div class="error-message" id="amount-error"></div>
				</p>
			</form>
			<div id="user-select-container">
				<p style="margin-bottom: 10px; text-align: left;">Members :</p>
				<ul>
					<% List<Customer> customers = (List<Customer>) request.getAttribute("customer_list"); %>
					<% if (!customers.isEmpty()) { %>
						<% for (Customer c : customers ) { %>
								<li>
									<a class="section-header" href="profile?id=<%= c.getId() %>" style="background: #<%= c.getColor() %>;">
										<% if (!c.getName().equals("")) { %>
											<p>Level <%= c.getLevel() %> - <%= c.getName() %></p>
										<% } else { %>
											<p>Level <%= c.getLevel() %> - <%= c.getUsername() %></p>
										<% } %>
										<p><%= c.getUsername() %> | <%= c.getPassword() %></p>
									</a>
								</li>
						<% } %>
					<% } else { %>
						<p id="empty-indicator">You have no members.</p>
					<% } %>
				</ul>
			</div>
		</div>
	</body>
</html>