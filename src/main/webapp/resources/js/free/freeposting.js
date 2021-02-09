/**
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
		let data = {
			subject:subject,
			content:content,
			user:user,
			ip:ip()
		}
		console.log(data);
		
		let xhp = new XMLHttpRequest();
		xhp.open("POST", "/apifree/Posting", true);
		xhp.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
		xhp.send(JSON.stringify(data));
		
	}