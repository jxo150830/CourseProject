<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="style/main.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<title>Home</title>
	</head>
	<body>
		<%@ include file="navigation/sidebar.jsp" %>
		<div id="content-container">
			<div id="welcome-container">
				<h1 id="welcome-title">Training</h1>
				<p id="welcome-subtitle">[ subtitle goes here ]</p>
			</div>
			<div id="level-select-container">
				<ul>
					<li><a class="section-header" href="training/introduction.jsp">Introduction</a></li>
					<li><a class="section-header" href="training/input.jsp">Input Training</a></li>
					<li><a class="section-header" ${sel_sty}>Selection Training ${sel_msg}</a></li>
					<li><a class="section-header" ${adv_sty}>Advanced Training ${adv_msg}</a></li>
					<li><a class="section-header" ${fre_sty}>Free Training ${fre_msg}</a></li>
				</ul>
			</div>
		</div>
	</body>
</html>