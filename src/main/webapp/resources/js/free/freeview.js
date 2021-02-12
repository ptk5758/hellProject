/**
 * 
 */
	let getFreeVO = (uid) => {
		let promise = new Promise((resolve, reject) => {
			let xhp = new XMLHttpRequest();
			xhp.open("GET", "/apifree/GetFreeVO?uid="+uid, true);
			xhp.send(null);
			xhp.onreadystatechange = () => {
				if(xhp.readyState === 4 && xhp.status === 200){
					resolve(JSON.parse(xhp.responseText));
				}
			}
		});
		
		promise.then((data) => {
			let viewBoard = document.getElementById('viewBoard');
			let result = "";
			result += `
				<div class="viewBoard_SubjectBoard">${data.subject}</div>
				<div class="viewBoard_itenInfo">
					<div class="viewBoard_itenInfo_user">
						<span class="bold">작성자</span>
						<span>${data.user}</span>
					</div>
					<div class="viewBoard_itenInfo_ref">
						<span class="bold">조회수</span>
						<span>${data.ref}</span>
					</div>
					<div class="viewBoard_itenInfo_like">
						<span class="bold">추천</span>
						<span id="likecount" data-count="${data.likestack}">${data.likestack}</span>
					</div>
				</div>
				<div class="viewBoard_contentBoard">
					${data.img === "" ? "":`<div><img src="/upload/${data.img}"></div>`}
					<div>${data.content}</div>
				</div>
			`;
			
			viewBoard.innerHTML = result;
			return data;
		})
		.then((data) => {
			let user = sessionStorage.getItem("sessionID");
			
			if(user == null || user === ""){
				document.getElementById('likecheck').checked = true;
			} else {
				let xhp = new XMLHttpRequest();
				xhp.open("GET", `/apifree/GetLikeValue?user=${user}&uid=${data.uid}`, true);
				xhp.send(null);
				xhp.onreadystatechange = () => {
					if(xhp.readyState === 4 && xhp.status === 200){
						let data = JSON.parse(xhp.responseText);
						if(data.value){
							document.getElementById('likecheck').checked = true;
						} else {
							document.getElementById('likecheck').checked = false;
						}
					}
				}
			}
			
		});
	}
	
	let likebutton = document.getElementById('likebutton');
	likebutton.addEventListener("click",(event)=>{
		/*console.log(event);*/
		let likevalue =  document.getElementById('likecheck');
		if(likevalue.checked){						
			likedelete(likevalue.value);
		} else {			
			likedo(likevalue.value);			
		}
	});
	
	let likedo = (uid) => {		
		let userid = sessionStorage.getItem("sessionID");
		if(userid == null || userid === ""){
			alert("로그인후에 이용하실수 있습니다.");
			document.getElementById('likecheck').checked = true;
			return;
		}
		
		let formData = new FormData();
		formData.append("uid", uid);
		formData.append("user", userid);
		let promise = new Promise((resolve,reject) => {
			let xhp = new XMLHttpRequest();
			xhp.open("POST", "/apifree/Likedo", true);
			xhp.send(formData);
			xhp.onreadystatechange = () => {
				if(xhp.readyState === 4 && xhp.status === 200){
					resolve(JSON.parse(xhp.responseText));					
				}
			}
			
		});
		
		promise.then((res) => {
			if(res.msg === "실패"){
				alert("알수없는 원인으로 인하여 추천에 실패하였습니다.");
				document.getElementById('likecheck').checked = true;
				return;
			} else {
				let likeBoard = document.getElementById('likecount');
				let newcount =	parseInt(likeBoard.getAttribute('data-count'))+1
				likeBoard.dataset.count = newcount;
				likeBoard.innerHTML = newcount;
			}
			
		});
	}
	
	
	let likedelete = (uid) => {
		let user = sessionStorage.getItem("sessionID");
		
		let data = {
			user: user,
			uid: uid
		}
		
		let xhp = new XMLHttpRequest();
		xhp.open("DELETE", `/apifree/LikeDelete?user=${user}&uid=${uid}`, true);
		xhp.send(null);
		
		xhp.onreadystatechange = () => {
			if(xhp.readyState === 4 && xhp.status === 200){
				let likeBoard = document.getElementById('likecount');
				let newcount =	parseInt(likeBoard.getAttribute('data-count'))-1
				likeBoard.dataset.count = newcount;
				likeBoard.innerHTML = newcount;
			}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	