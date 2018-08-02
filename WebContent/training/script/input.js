function vendInput(append) {
	if (document.getElementById("vend-input-display").innerHTML.length >= 3)
		document.getElementById("vend-input-display").innerHTML = append;
	else
		document.getElementById("vend-input-display").innerHTML += append;
}

function clearVendInput() {
	document.getElementById("vend-input-display").innerHTML = "";
}

function vendValidate() {
	if (document.getElementById("vend-input-display").innerHTML == "D12")
		return true;
	else
		return false;
}