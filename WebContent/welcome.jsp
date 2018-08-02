<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="style/main.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<title>Welcome</title>
	</head>
	<body>
		<div id="welcome-page-container">
			<div id="welcome-container">
				<h1 id="welcome-title">Welcome to the Virtual Vending Machine,</h1>
				<p id="welcome-subtitle">the world-class premier tool for learning to use a vending machine.</p>
			</div>
			<div id="account-option-container">
				<div class="account-option">
					<p>Are you an individual looking to unlock new career opportunities through personalized online training?</p>
					<a class="account-button" id="personal-account-button" href="register?account=personal">create a<br>Personal Account</a>
				</div>
				<div class="account-option">
					<p>Are you a group looking to employ or train certified vending-machine testers?</p>
					<a class="account-button" id="enterprise-account-button" href="register?account=enterprise">create an<br>Enterprise Account</a>
				</div>
			</div>
			<div id="login-button-container">
				<p>Already have an account?</p>
				<a class="account-button" id="login-button" href="login">Login</a>
			</div>
		</div>
	</body>
</html>