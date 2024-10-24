let listMaKH = [];
let KhachHangID;

$(document).ready(function() {
	let maKH = $(".form").find(".txt-maKH");
	for (let i = 0; i < maKH.length; i++) {
		listMaKH[i] = $(maKH[i]).text();
	}
	
	//delete element
	$("#id-delete").on("click", function() {
		let url = "/Spring_General/customer/delete/" + KhachHangID;
		window.location.href = url;
	});

	//Click page add update
	$("#id-close").click(function() {
		window.location.href = "/Spring_General/customer/closeAdd";
	});

	$("#add-btn").click(function() {
		window.location.href = "/Spring_General/customer/add";
	});

});

function setIndexDelete(i) {
	KhachHangID = listMaKH[i-1];
}

function showEditData(i) {
	window.location.href = "/Spring_General/customer/edit/" + listMaKH[i-1];
}