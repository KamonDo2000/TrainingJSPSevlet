$(document).ready(function() {
	$("#id-input-5").on("change", function() {
		let num = $("#id-input-5").val();
		if (num <= 0) {
			alert("Thời Gian sử dụng lớn hơn 0");
			$("#id-input-5").val(1);
		}
	});
});