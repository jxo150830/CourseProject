<%@ page import="stuff.Message" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="style/main.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<title>Messages</title>
	</head>
	<body>
		<%@ include file="navigation/sidebar.jsp" %>
		<div id="content-container">
			<div id="welcome-container">
				<h1 id="welcome-title">Messages</h1>
				<p id="welcome-subtitle">[ subtitle goes here ]</p>
			</div>
			<% List<Message> messages = (List<Message>) request.getAttribute("message_list"); %>
			<% if (!messages.isEmpty()) { %>
				<% for (Message m : messages) { %>
					<div class="section-container" id="message-container">
						<h2 class="section-header" id="subject"><%= m.getSubject() %></h2>
						<div class="section-contents">
							<p id="sender">
								<% if (!m.getSender().getName().equals("")) { %>
								From: <%= m.getSender().getName() %>
							<% } else { %>
								From: <%= m.getSender().getUsername() %>
							<% } %>
						</p>
							<p id="date">Sent on: <%= m.getDate() %></p>
							<p id="body"><%= m.getBody() %></p>
						</div>
					</div>
				<% } %>
			<% } else { %>
				<p id="empty-indicator">You have no messages.</p>
			<% } %>
		</div>
	</body>
</html>