let maMayDel;

$(document).ready(function() {
	//delete element
	$("#id-delete").on("click", function() {
		let url = "/Spring_General/computer/deleteComp/" + maMayDel;
		window.location.href = url;
	});

	//Click page add update
	$("#id-close").click(function() {
		window.location.href = "/Spring_General/computer/closeAdd";
	});

	$("#add-btn").click(function() {
		window.location.href = "/Spring_General/computer/AddIndex";
	});

});

function setIndexDelete(i) {
	maMayDel = i;
}

function showEditData(maMay) {
	window.location.href = "/Spring_General/computer/EditIndex/" + maMay;
}
