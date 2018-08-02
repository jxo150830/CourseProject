function messageValidate() {
	var subject = document.forms["message-form"]["subject"].value;
	var body = document.forms["message-form"]["body"].value;
	
	if (subject == "")
		document.getElementById("subject-error").innerHTML = "Subject must be filled out.";
	else
		document.getElementById("subject-error").innerHTML = "";
	if (body == "")
		document.getElementById("body-error").innerHTML = "Body must be filled out.";
	else
		document.getElementById("body-error").innerHTML = "";

	if (subject == "") {
        document.forms["message-form"]["subject"].focus();
        return false;
    }
	if (body == "") {
        document.forms["message-form"]["body"].focus();
        return false;
    }
}