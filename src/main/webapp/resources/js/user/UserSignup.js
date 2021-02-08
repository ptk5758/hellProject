/**
 * 
 */

	console.log(document.getElementsByName('id'));
	
	let signupdo = () => {		
		
		let id = document.querySelector('[name="id"]').value;
		let password = document.querySelector('[name="password"]').value;
		let passwordcheck = document.querySelector('[name="passwordcheck"]').value;		
		if(password != passwordcheck){
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}		
		let name = document.querySelector('[name="name"]').value;
		let age = document.querySelector('[name="age"]').value;
		let nickname = document.querySelector('[name="nickname"]').value;
		let gender = document.querySelector('[name="gender"]:checked').value;		
		let email1 = document.getElementById('email1').value;
		let email2 = document.getElementById('email2').value;
		let email = `${email1}@${email2}`;
		if(email2 == "write"){
			email = email1;
		}
		
		let data = {
			id: id,
			password: password,
			name: name,
			age: age,			
			nickname: nickname,
			gender: gender,
			email: email
		}
		console.log(JSON.stringify(data));
		
		let xhp = new XMLHttpRequest();
		xhp.open("POST", "/apiuser/signup", true);
		xhp.setRequestHeader("Content-Type","application/json; charset=UTF-8");
		xhp.send(JSON.stringify(data));
		
		
	}