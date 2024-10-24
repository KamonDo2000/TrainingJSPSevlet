$().ready(function() {
	
	/* validate create new user function */
	$("#createUser").validate({
		onfocusout : false,
		onkeyup : false,
		onclick : false,
		rules : {
			"username" : {
				maxlength: 50,
				required : true,
			},
			"password" : {
				maxlength: 15,
				required : true
			},
			"email" : {
				maxlength: 50
			},
			"profile" : {
				maxlength: 50
			},
		},
		
		// when all input are valid
		submitHandler : function() {
			// show confirm message
			showDialog("Confirm","Do you want to create new user?","confirmtype");
			
			// case user click close button
			document.getElementById("closebutton").onclick = function() {
				closeDialog();
			};
			
			// case user click close button
			document.getElementById("submitbutton").onclick = function() {
				$("#myModal").modal('toggle');
				document.getElementById("createUser").submit();
			};
		},  
	});

	/* validate login function */
	$("#doLogin").validate({
		onfocusout : false,
		onkeyup : false,
		onclick : false,
		rules : {
			"username" : {
				required : true,
				maxlength: 50
			},
			"password" : {
				required : true,
				maxlength: 15
			},
		},

	});
	
	/**
	 * function to show note message 
	 * @returns
	 */
	function submitDialog(){
		showDialog("Congratulation!!!!!", "You successfully create new user.","infotype");
	}
	
	/**
	 * function to close the message
	 * @returns
	 */
	function closeDialog(){
		var whitebg = document.getElementById("white-background");
		var dlg = document.getElementById("dlgbox");
		
		whitebg.style.display = "none";
		dlg.style.display = "none";
	}
	
	/**
	 * function to show the dialog 
	 * @param msgheader
	 * @param msgbody
	 * @param dialogtype
	 * @returns
	 */
	function showDialog(msgheader,msgbody,dialogtype ){
		var paragraph = document.getElementById("dlg-header");
		paragraph.textContent = msgheader;
		
		paragraph = document.getElementById("dlg-body");
		paragraph.textContent 	= msgbody;
		
		//check what type of dialog by dialogtype parameter
		if(dialogtype == "confirmtype"){ // case confirm
			paragraph = document.getElementById("submitbutton");
			paragraph.textContent 	= "submit";
			paragraph.style.display = "initial";
			
			paragraph = document.getElementById("closebutton");
			paragraph.textContent 	= "cancel";
		}
		else if(dialogtype == "infotype"){ // case info
			paragraph = document.getElementById("submitbutton");
			paragraph.style.display = "none";
			
			paragraph = document.getElementById("closebutton");
			paragraph.textContent 	= "Ok";
		}
		
		var whitebg = document.getElementById("white-background");
		var dlg = document.getElementById("dlgbox");
		
		whitebg.style.display = "block";
		dlg.style.display = "block";
		
		var winWidth = window.innerWidth;
		var winHeight = window.innerHeight;
		
		dlg.style.top = "200px";
	}
	
	document.getElementById("closebutton").onclick = function() {
		closeDialog();
	};

});
