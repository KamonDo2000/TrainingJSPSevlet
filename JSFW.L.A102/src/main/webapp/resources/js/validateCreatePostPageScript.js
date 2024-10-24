$().ready(function() {
	/*validate Create post page */
	$("#savePost").validate({
		onfocusout : false,
		onkeyup : false,
		onclick : false,
		
		// rule
		rules : {
			"title" : {
				maxlength: 50,
				required : true,
				
			},
			"content" : {
				maxlength: 20000,
				required : true,
			},
			"tags" : {
				maxlength: 50,
			}
		},
		
		// when all input are valid
		submitHandler : function() {
			// show confirm message
			showDialog("Confirm","Do you want to create new post?","confirmtype");
			
			// case user click close button
			document.getElementById("closebutton").onclick = function() {
				closeDialog();
			};
			
			// case user click close button
			document.getElementById("submitbutton").onclick = function() {
				document.getElementById("savePost").submit();
			};
		},  
	});

	/**
	 * function to show note message 
	 * @returns
	 */
	function submitDialog(){
		// case success
		showDialog("Congratulation!!!!!", "You successfully create new post.","infotype");
		// case failed
		// showDialog("Sorry!!!", "The system have problem. Please come back later.","infotype");
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
		
		dlg.style.left = (winWidth/2) -480/2 + "px";
		dlg.style.top = "200px";
	}


});
