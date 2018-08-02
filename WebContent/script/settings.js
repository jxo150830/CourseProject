function settingsValidate() {
	var newName = document.forms["settings-form"]["new-name"].value;
	var newUsername = document.forms["settings-form"]["new-username"].value;
	var newPassword = document.forms["settings-form"]["new-password"].value;
	var currentPassword = document.forms["settings-form"]["current-password"].value;
	
	if ((newName != "" || newUsername != "" || newPassword != "") && currentPassword == "")
		document.getElementById("current-password-error").innerHTML = "Current password must be filled out.";
	else
		document.getElementById("current-password-error").innerHTML = "";

	if ((newName != "" || newUsername != "" || newPassword != "") && currentPassword == "") {
        document.forms["settings-form"]["current-password"].focus();
        return false;
    }
}