<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="script/message.js"></script>
		<link rel="stylesheet" href="style/main.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<title>${profile_name}'s Profile</title>
	</head>
	<body>
		<%@ include file="navigation/sidebar.jsp" %>
		<div id="content-container">
			<div id="welcome-container">
				<div id="profile-picture" style="background: #${profile_color};"></div>
				<h1 id="profile-name">${profile_name}</h1>
				<% if ((Integer) request.getAttribute("profile_is_enterprise") == 0) { %>
					<p id="profile-level">Level ${profile_level}${profile_enterprise}</p>
				<% } else { %>
					<p id="profile-level">Enterprise</p>
				<% } %>
			</div>
			<div class="section-container">
				<h2 class="section-header" style="background: #${profile_color};">About</h2>
				<p class="section-contents">${profile_about}</p>
			</div>
			<% if (request.getAttribute("id") != request.getAttribute("profile_id")) { %>
				<div class="section-container">
					<h2 class="section-header" style="background: #${profile_color};">Message</h2>
					<div class="section-contents" id="notice-container" ${notice_display}>${notice}</div>
					<form class="section-contents text-form" id="message-form" name="message-form" action="profile?id=${profile_id}" method="post" onsubmit="return messageValidate()">
						<input type="hidden" id="receiver" name="receiver" value="${profile_id}">
						Subject<br>
						<input class="input-box" id="subject" type="text" name="subject" maxlength="32"><br>
						<div class="error-message" id="subject-error"></div>
						Body<br>
						<input class="input-box" id="body" type="text" name="body" maxlength="255">
						<div class="error-message" id="body-error"></div>
						<input class="input-box input-button" id="submit" type="submit" name="submit" value="Send">
					</form>
				</div>
			<% } %>
		</div>
	</body>
</html>