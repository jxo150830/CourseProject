<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="script/input.js"></script>
		<link rel="stylesheet" href="style/exercise.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<title>test vend</title>
	</head>
	<body>
		<p>Input D12</p><br>
		<form class="vend-form" name="vend-form" action="/CourseProject/TrainingController" method="post" onsubmit="return vendValidate()">
			<div id="keypad-button-container">
				<% char[] buttonLabels = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
				for (int i = 0; i < 4; i++ ) {
					for (int j = 0; j < 4; j++ ) {
						if (j != 3)
							request.setAttribute("style", "style=\"margin: 0 10px 10px 0;\"");
						else
							request.setAttribute("style", "style=\"margin: 0 0 10px 0;\""); %>
						<input class="keypad-button" type="submit" name="submit" value="<%= buttonLabels[4*i+j] %>" onclick="vendInput('<%= buttonLabels[4*i+j] %>')" ${style}>
					<% }
				} %>
				<input class="keypad-button" id="clear-keypad-button" type="button" name="button" value="clear" onclick="clearVendInput()">
			</div>
		</form><br>
		<p>INPUT:&nbsp;</p><p id="vend-input-display"></p><br>
	</body>
</html>