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
		let myfile = document.getElementById('myfile').files[0];
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
		
		xhp.onreadystatechange = () => {
			if(xhp.status === 200 && xhp.readyState === 4){
				let jsonData = JSON.parse(xhp.responseText);
				if(jsonData.msg === "성공"){
					alert(jsonData.comment);
					location.href="/";
				}
			}
		}
		
	}
	
	
	let showimg = (e) => {
		e.preventDefault();
		let reader = new FileReader();
		console.log(e);
		console.log(e.target.files[0]);
		reader.readAsDataURL(e.target.files[0]);
		reader.onload = (readevent) => {
			let filename = e.target.files[0].name;
			let resultimg = document.getElementById('showimg');
			resultimg.src = readevent.target.result;
			document.getElementById('filetextresult').innerHTML = `
				<label for="myfile" id="fileupbutton">파일첨부</label>
				<span>${filename}</span>
			`; 
		}
		
	}
	
	let dragdrop = (e) => {
		e.preventDefault();
	}
	let dragover = (e) => {
		e.preventDefault();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	