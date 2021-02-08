/**
 * 
 */

	let logout = () => {
		console.log("로그아웃");
		sessionStorage.clear();
		location.href="/logout";
	}
	
	let login = () => {
		let promise = new Promise((resolve, reject) => {
			let id = document.getElementById('id').value;
			let password = document.getElementById('password').value;
			let data = {
				id:id,
				password:password
			}
						
			let xhp = new XMLHttpRequest();
			xhp.open("POST", "/apiuser/login", true);
			xhp.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
			xhp.send(JSON.stringify(data));			
			
			xhp.onreadystatechange = () =>{
				if(xhp.readyState === 4 && xhp.status === 200){
					resolve(xhp.responseText);
				}
			}
		});
		
		promise.then((res) => {
			let jsonData = JSON.parse(res);
			if(jsonData.msg != null){
				alert(jsonData.comment);
				return;
			}
			sessionStorage.setItem("sessionID", jsonData.id);
			sessionStorage.setItem("sessionNickName", jsonData.nickname);
			sessionStorage.setItem("sessionLevel", jsonData.level);
			alert("로그인 되었습니다!");
			location.reload();
		});
	}