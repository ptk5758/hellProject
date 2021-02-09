/**
 * 
 */

	let idsearchdo = () => {		
		let promise = new Promise((resolve,reject) => {		
			let name = document.querySelector('input[name="name"]').value;
			let email = document.querySelector('input[name="email"]').value;
			let id = document.querySelector('input[name="id"]').value;
			let data = {
				name:name,
				email:email,
				id:id
			}	
			let xhp = new XMLHttpRequest();
			xhp.open("POST", "/apiuser/pwsearch", true);
			xhp.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
			xhp.send(JSON.stringify(data));
			
			xhp.onreadystatechange = () => {
				if(xhp.status === 200 && xhp.readyState === 4){
					resolve(JSON.parse(xhp.responseText));
				}
			}
		});
		promise.then((res) => {
			if(res.msg === "실패"){
				alert(res.comment);
				return;
			} else {
				let resultboard = document.getElementsByClassName('idsearchContent')[0];
				let result = "";
				result += `
					<div class="idsearch_ResultBoard">
						<div class="idsearch_ResultBoard_Item">
							<div><b>${res.name}</b> 의 비밀번호는</div>
						</div>
						<div class="idsearch_ResultBoard_Item">
							<div>"${res.password}" 입니다.</div>
						</div>
						<div class="idsearch_ResultBoard_Item">
							<button id="closeBth" onclick="window.close()">닫기</button>
						</div>
					</div>
				`;				
				resultboard.innerHTML = result;
			}
		});
	}