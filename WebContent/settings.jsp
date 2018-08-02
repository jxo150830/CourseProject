<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="script/settings.js"></script>
		<link rel="stylesheet" href="style/main.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<title>Settings</title>
	</head>
	<body>
		<%@ include file="navigation/sidebar.jsp" %>
		<div id="content-container">
			<div id="welcome-container">
				<h1 id="welcome-title">Settings</h1>
				<p id="welcome-subtitle">[ subtitle goes here ]</p>
			</div>
			<div id="notice-container" ${notice_display}>${notice}</div>
			<form id="settings-form" name="settings-form" action="settings" method="post" onsubmit="return settingsValidate()">
				<div class="section-container">
					<p class="section-header">Account</p>
					<div class="section-contents text-form" id="account-settings">
						New name<br>
						<input class="input-box" id="new-name" type="text" name="new-name" maxlength="32"><br>
						<div class="error-message" id="new-name-error"></div>
						New username<br>
						<input class="input-box" id="new-username" type="text" name="new-username" maxlength="32"><br>
						<div class="error-message" id="new-username-error"></div>
						New password<br>
						<input class="input-box" id="new-password" type="password" name="new-password" maxlength="32"><br>
						<div class="error-message" id="new-password-error"></div>
						Current password<br>
						<input class="input-box" id="current-password" type="password" name="current-password" maxlength="32"><br>
						<div class="error-message" id="current-password-error"></div>
					</div>
				</div>
				<div class="section-container">
					<p class="section-header">Profile Color</p>
					<div class="section-contents" id="color-settings">
						<input class="input-box" type="radio" name="color" id="4b4b4b" value="4b4b4b" ${checked_4b4b4b}>
						<label for="4b4b4b" style="background: #4b4b4b;"></label>
						<input class="input-box" type="radio" name="color" id="6082b6" value="6082b6" ${checked_6082b6}>
						<label for="6082b6" style="background: #6082b6;"></label>
						<input class="input-box" type="radio" name="color" id="8a9a5b" value="8a9a5b" ${checked_8a9a5b}>
						<label for="8a9a5b" style="background: #8a9a5b;"></label>
						<input class="input-box" type="radio" name="color" id="cd5c5c" value="cd5c5c" ${checked_cd5c5c}>
						<label for="cd5c5c" style="background: #cd5c5c;"></label>
					</div>
				</div>
				<div class="section-container">
					<p class="section-header">About</p>
					<div class="section-contents text-form" id="about-settings">
						<input class="input-box" id="about" type="text" name="about" value="${about}" maxlength="255"><br>
					</div>
				</div>
				<input class="input-box input-button" id="submit" type="submit" name="submit" value="Submit">
			</form>
		</div>
	</body>
</html>