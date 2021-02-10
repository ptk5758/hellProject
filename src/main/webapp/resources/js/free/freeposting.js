4/**
 * 
 */
	console.log("freeposting");
	
	let postingdo = () => {
		let subject = document.querySelector('input[name="subject"]').value;
		let content = document.querySelector('textarea[name="content"]').value;
		let user = sessionStorage.getItem("sessionID");
		if(user == null || user === ""){
			alert("로그인 후에 이용하실수 있습니다.");
			return;
		}
		let myfile = document.getElementById('myimg').files[0];
		myfile ? myfile=myfile:myfile=null;
		console.log(myfile);
		let formData = new FormData();
		formData.append("subject", subject);
		formData.append("content", content);
		formData.append("user", user);		
		formData.append("ip", ip());
		formData.append("file", myfile);
		/*myfile ? formData.append("file", myfile): console.log("파일없음");*/
		
		let xhp = new XMLHttpRequest();
		xhp.open("POST", "/apifree/Posting", true);
		xhp.send(formData);
		
	}