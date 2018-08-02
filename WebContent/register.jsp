<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="script/loginreg.js"></script>
		<link rel="stylesheet" href="style/main.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<title>Register</title>
	</head>
	<body>
		<div id="reg-container">
			<div id="notice-container" ${notice_display}>${notice}</div>
			<form class="text-form" id="reg-form" name="reg-form" action="LoginController" method="post" onsubmit="return regValidate()">
				<input type="hidden" id="is-enterprise" name="is-enterprise" value="${is_enterprise}">
				<% if (request.getParameter("account").equals("enterprise")) { %>
					Enterprise name
				<% } else { %>
					Name
				<% } %>
				<br>
				<input class="input-box" id="name" type="text" name="name" maxlength="32"><br>
				<div class="error-message" id="name-error"></div>
				Username<br>
				<input class="input-box" id="username" type="text" name="username" value="${username}" maxlength="32"><br>
				<div class="error-message" id="username-error"></div>
				Password<br>
				<input class="input-box" id="password" type="password" name="password" maxlength="32"><br>
				<div class="error-message" id="password-error"></div>
				Re-type password<br>
				<input class="input-box" id="retry-password" type="password" name="retry-password" maxlength="32"><br>
				<div class="error-message" id="retry-password-error"></div>
				
				<input class="input-box input-button" id="submit" type="submit" name="submit" value="Register" >
				<input class="input-box input-button" id="reset" type="reset" name="reset"><br>
				<a href="welcome">back</a>
			</form>
		</div>
	</body>
</html>