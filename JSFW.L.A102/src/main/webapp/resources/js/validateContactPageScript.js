$().ready(function() {
	/*validate contact page */
	$("#contact").validate({
		onfocusout : false,
		onkeyup : false,
		onclick : false,
		
		// rule
		rules : {
			"email" : {
				required : true
			},
			"name" : {
				required : true
			},
			"subject" : {
				required : true
			},
			"body" : {
				required : true
			},
		},
		
		// when all input are valid
		submitHandler : function() {
			// show confirm message
			showDialog("Confirm","Do you want to confirm this contact?","confirmtype");
			
			// case user click close button
			document.getElementById("closebutton").onclick = function() {
				closeDialog();
			};
			
			// case user click submit button
			document.getElementById("submitbutton").onclick = function() {
				submitDialog();
			};
		},  
	});

	/**
	 * function to show note message 
	 * @returns
	 */
	function submitDialog(){
		showDialog("Thank you!!!", "Thank you for contacting us. We will reply you as soon as possible.","infotype");
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
});
