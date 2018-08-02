<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="script/loginreg.js"></script>
		<link rel="stylesheet" href="style/main.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<title>Login</title>
	</head>
	<body>
		<div id="login-container">
			<div id="notice-container" ${notice_display}>${notice}</div>
			<form class="text-form" id="login-form" name="login-form" action="LoginController" method="post" onsubmit="return loginValidate()">
				Username<br>
				<input class="input-box" id="username" type="text" name="username" maxlength="32"><br>
				<div class="error-message" id="username-error"></div>
				Password<br>
				<input class="input-box" id="password" type="password" name="password" maxlength="32"><br>
				<div class="error-message" id="password-error"></div>
				<input class="input-box input-button" id="submit" type="submit" name="submit" value="Login">
				<a href="welcome">back</a>
			</form>
		</div>
	</body>
</html>