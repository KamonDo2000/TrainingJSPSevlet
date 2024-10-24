let listMaDV = [];
let maDVDel;

$(document).ready(function() {
	let maDV = $(".form").find(".txt-MaDV");
	for (let i = 0; i < maDV.length; i++) {
		listMaDV[i] = $(maDV[i]).text();
	}
	
	//delete element
	$("#id-delete").on("click", function(e) {
		let url = "/Spring_General/dichvu/delete/" + maDVDel;
		window.location.href = url;
	});

	//Click page add update
	$("#id-close").click(function() {
		window.location.href = "/Spring_General/dichvu/closeAdd";
	});

	$("#add-btn").click(function() {
		window.location.href = "/Spring_General/dichvu/add";
	});
	
});

function setIndexDelete(i) {
	maDVDel = listMaDV[i-1];
}

function showEditData(i) {
	window.location.href = "/Spring_General/dichvu/edit/" + listMaDV[i-1];
}
