$().ready(function() {

	/* validate login function */
	$("#saveComment").validate({
		onfocusout : false,
		onkeyup : false,
		onclick : false,
		rules : {
			"author" : {
				required : true,
			},
			"email" : {
				required : true
			},
		},

	});
	
});
