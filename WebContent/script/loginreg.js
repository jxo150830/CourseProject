function loginValidate() {
	var username = document.forms["login-form"]["username"].value;
	var password = document.forms["login-form"]["password"].value;

	if (username == "")
		document.getElementById("username-error").innerHTML = "Username must be filled out.";
	else
		document.getElementById("username-error").innerHTML = "";
	
	if (password == "")
		document.getElementById("password-error").innerHTML = "Password must be filled out.";
	else
		document.getElementById("password-error").innerHTML = "";

	if (username == "") {
        document.forms["login-form"]["username"].focus();
        return false;
    }
	else if (password == "") {
        document.forms["login-form"]["password"].focus();
        return false;
    }
}

// document.getElementById("password").setAttribute("type", "text");

function regValidate() {
	var name = document.forms["reg-form"]["name"].value;
	var username = document.forms["reg-form"]["username"].value;
	var password = document.forms["reg-form"]["password"].value;
	var retryPassword = document.forms["reg-form"]["retry-password"].value;
	var isEnterprise = document.forms["reg-form"]["is-enterprise"].value;
	
	if (isEnterprise == 1 && name == "") {
		document.getElementById("name-error").innerHTML = "Name is required for Enterprise accounts.";
	}
	else
		document.getElementById("name-error").innerHTML = "";
	if (username == "")
		document.getElementById("username-error").innerHTML = "Username must be filled out.";
	else
		document.getElementById("username-error").innerHTML = "";
	
	if (password == "")
		document.getElementById("password-error").innerHTML = "Password must be filled out.";
	else
		document.getElementById("password-error").innerHTML = "";
	
	if (retryPassword == "")
		document.getElementById("retry-password-error").innerHTML = "Retry-password must be filled out.";
	else if (password != retryPassword)
		document.getElementById("retry-password-error").innerHTML = "Password doesn't match.";
	else
		document.getElementById("retry-password-error").innerHTML = "";

	if (isEnterprise == 1 && name == "") {
        document.forms["reg-form"]["name"].focus();
        return false;
    }
	else if (username == "") {
        document.forms["reg-form"]["username"].focus();
        return false;
    }
	else if (password == "") {
        document.forms["reg-form"]["password"].focus();
        return false;
    }
	else if (retryPassword == "") {
        document.forms["reg-form"]["retry-password"].focus();
        return false;
    }
	else if (password != retryPassword) {
        document.forms["reg-form"]["password"].focus();
        return false;
    }
}