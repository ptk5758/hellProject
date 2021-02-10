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
				<div class="freeBoardList_Like">1</div>
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