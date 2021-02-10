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
			console.log(data);
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
						<span>${data.ref}</span>
					</div>
				</div>
				<div class="viewBoard_contentBoard">
					${data.img === "" ? "":`<div><img src="/upload/${data.img}"></div>`}
					<div>${data.content}</div>
				</div>
			`;
			
			viewBoard.innerHTML = result;
			
		});
	}