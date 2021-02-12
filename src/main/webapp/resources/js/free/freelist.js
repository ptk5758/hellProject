/**
 * 
 */
	console.log("freelist");
	
	let promise = new Promise((resolve,reject) => {
		let xhp = new XMLHttpRequest();
		xhp.open("GET", "/apifree/GetList", true);
		xhp.send(null);		
		xhp.onreadystatechange = () => {
			if(xhp.readyState === 4 && xhp.status === 200){
				resolve(JSON.parse(xhp.responseText));
			}
		}
	});
	
	promise.then((data) => {
		console.log(data);		
		let freeBoard = document.getElementById('freeBoard');
		let totalcount = data.count;
		let result = "";		
		for(let item of data.list){
			result += `
			<div class="freeBoardList">
				<div class="freeBoardList_Num">${totalcount}</div>
				<div class="freeBoardList_Subject" data-uid="${item.uid}" onclick="viewpage(this)">${item.subject}</div>				
				<div class="freeBoardList_User">${item.user}</div>
				<div class="freeBoardList_Date">${item.uploadDate}</div>
				<div class="freeBoardList_Ref">${item.ref}</div>
				<div class="freeBoardList_Like">${item.likestack}</div>
			</div>
		`;
		totalcount--;
		}
			
		freeBoard.innerHTML += result;		
		return data.page;
	}).then((page) => {
		console.log(page);
		let pageButtnEle = document.getElementById('freeBoardPage');
		let i = 1;
		let result = ``;
		for(i; i<=page.totalpage; i++){
			result += `
				<div onclick="viewthispage(this)" data-nowpage="${i}">${i}</div>
			`;
		}
		pageButtnEle.innerHTML = result;
		return page;
	}).then((page) => {
		let nowpage = page.nowpage;
		let nowpagebutton = document.querySelectorAll(`div[data-nowpage="${nowpage}"]`)[0];
		nowpagebutton.style.color = "red";
		console.log(nowpagebutton);
	});
	
	let viewpage = (item) => {
		console.log(item);
		location.href="/bbs/free/"+item.getAttribute("data-uid");
	}
	
	let searchdo = () => {
		let title = document.querySelector('select[name="title"]').value;
		let value = document.querySelector('input[name="value"]').value;
		
		let promise = new Promise((resolve, reject) => {
			
			let xhp = new XMLHttpRequest();
			xhp.open("GET", `/apifree/GetList?selecttitle=${title}&inputvalue=${value}`, true);
			xhp.send(null);		
			
			xhp.onreadystatechange = () => {
				if(xhp.status === 200 && xhp.readyState === 4){
					resolve(JSON.parse(xhp.responseText));					
				}
			}
			
			
		});
		
		promise.then((data) => {
		console.log(data);		
		let freeBoard = document.getElementById('freeBoard');
		let totalcount = data.count;
		let result = `
			<div class="freeBoardList listtop">
				<div class="freeBoardList_Num">No</div>
				<div class="freeBoardList_Subject">제목</div>
				<div class="freeBoardList_User">유저</div>
				<div class="freeBoardList_Date">날짜</div>				
				<div class="freeBoardList_Ref">조회수</div>
				<div class="freeBoardList_Like">추천</div>
			</div>`;		
		for(let item of data.list){
			result += `
			<div class="freeBoardList">
				<div class="freeBoardList_Num">${totalcount}</div>
				<div class="freeBoardList_Subject" data-uid="${item.uid}" onclick="viewpage(this)">${item.subject}</div>				
				<div class="freeBoardList_User">${item.user}</div>
				<div class="freeBoardList_Date">${item.uploadDate}</div>
				<div class="freeBoardList_Ref">${item.ref}</div>
				<div class="freeBoardList_Like">${item.likestack}</div>
			</div>
		`;
		totalcount--;
		}
			
		freeBoard.innerHTML = result;		
		return data.page.page;
		}).then((page) => {
			console.log(page);
			let pageButtnEle = document.getElementById('freeBoardPage');
			let i = 1;
			let result = ``;
			for(i; i<=page.totalpage; i++){
				result += `
					<div onclick="viewthispage(this)" data-nowpage="${i}">${i}</div>
				`;
			}
			pageButtnEle.innerHTML = result;
			return page;
		}).then((page) => {
			let nowpage = page.nowpage;
			let nowpagebutton = document.querySelectorAll(`div[data-nowpage="${nowpage}"]`)[0];
			nowpagebutton.style.color = "red";
			console.log(nowpagebutton);
		});
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	