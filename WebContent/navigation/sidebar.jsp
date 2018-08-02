<div id="navigation-container">
	<div id="user-icon"></div>
	<div id="user-information">
		<p id="greeting-message">Hello, ${name}</p><br>
		<% if ((Integer) request.getAttribute("is_enterprise") == 0) { %>
			<p id="level-message">Level ${level}</p><br>
		<% } else { %>
			<p id="level-message">Enterprise</p><br>
		<% } %>
		<p id="logout-link">(&nbsp;<a href="logout.jsp">logout</a>&nbsp;)</p>
	</div>
	<div id="navigation-pages-container">
		<%
			String url = request.getRequestURL().toString();
			if (url.endsWith("home.jsp"))
				request.setAttribute("home_bg", "style=\"background: #4b4b4b; color: #f5f7f8;\"");
			else if (url.endsWith("profile.jsp") && (request.getAttribute("profile_id").equals(request.getAttribute("id"))))
				request.setAttribute("profile_bg", "style=\"background: #4b4b4b; color: #f5f7f8;\"");
			else if (url.endsWith("enterprise.jsp"))
				request.setAttribute("enterprise_bg", "style=\"background: #4b4b4b; color: #f5f7f8;\"");
			else if (url.endsWith("training.jsp"))
				request.setAttribute("training_bg", "style=\"background: #4b4b4b; color: #f5f7f8;\"");
			else if (url.endsWith("users.jsp"))
				request.setAttribute("users_bg", "style=\"background: #4b4b4b; color: #f5f7f8;\"");
			else if (url.endsWith("messages.jsp"))
				request.setAttribute("messages_bg", "style=\"background: #4b4b4b; color: #f5f7f8;\"");
			else if (url.endsWith("settings.jsp"))
				request.setAttribute("settings_bg", "style=\"background: #4b4b4b; color: #f5f7f8;\"");
		%>
		<ul>
			<li><a href="/CourseProject/home" ${home_bg}>Home</a></li>
			<li><a href="/CourseProject/profile?id=${id}" ${profile_bg}>Profile</a></li>
			<% if ((Integer) request.getAttribute("is_enterprise") == 0) { %>
				<li><a href="/CourseProject/training" ${training_bg}>Training</a></li>
			<% } else { %>
				<li><a href="/CourseProject/enterprise" ${enterprise_bg}>Enterprise</a></li>
			<% } %>
			<li><a href="/CourseProject/users" ${users_bg}>Users</a></li>
			<li><a href="/CourseProject/messages" ${messages_bg}>Messages</a></li>
			<li><a href="/CourseProject/settings" ${settings_bg}>Settings</a></li>
		</ul>
	</div>
</div>