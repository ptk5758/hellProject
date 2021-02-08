/**
 * 
 */
	
	let getBMIlist = () => {
		let promise = new Promise((resolve, reject) => {
			
			let xhp = new XMLHttpRequest();
			xhp.open("GET", "/apiWeight/getBMIList", true);
			xhp.send(null);
			
			xhp.onreadystatechange = () => {
				if(xhp.status === 200 && xhp.readyState === 4){
					resolve(xhp.responseText);
				}
			}
		});
		
		promise.then((value)=>{
			console.log(JSON.parse(value));
			let jsondata = JSON.parse(value);
			let listcount = jsondata.count;
			document.getElementById('countresult').innerHTML = listcount;
			let bmiboard = document.getElementById('bmiboard');
			let result = `
			<div class="bmi_list_item toplist">
				<div class="bmi_list_num bmi_top">Num</div>
				<div class="bmi_list_height bmi_top">키</div>
				<div class="bmi_list_weight bmi_top">몸무게</div>
				<div class="bmi_list_age bmi_top">나이</div>
				<div class="bmi_list_gender bmi_top">성별</div>
				<div class="bmi_list_BMI bmi_top">BMI</div>
				<div class="bmi_list_answer bmi_top">결과</div>
				<div class="bmi_list_date bmi_top">날짜</div>
				<div class="bmi_list_user bmi_top">유저</div>
			</div>
			`;
			for(let data of jsondata.list){
				
				let answercolor;
				if(data.bmi_status === "비만"){
					answercolor = "#ff0000";
				} else if (data.bmi_status === "과체중") {
					answercolor = "#b168ee";
				} else if (data.bmi_status === "정상") {
					answercolor = "#5cf928";
				} else if (data.bmi_status === "고도 비만")  {
					answercolor = "#ff2020";
				} else {
					answercolor = "#000000";
				}			
				
				result += `
					<div class="bmi_list_item">
						<div class="bmi_list_num">${listcount}</div>
						<div class="bmi_list_height">${data.height}</div>
						<div class="bmi_list_weight">${data.weight}</div>
						<div class="bmi_list_age">${data.age}</div>
						<div class="bmi_list_gender">${data.gender}</div>
						<div class="bmi_list_BMI">${data.bmi}</div>
						<div class="bmi_list_answer" style='color: ${answercolor}'>${data.bmi_status}</div>
						<div class="bmi_list_date">${data.uploadDate}</div>
						<div class="bmi_list_user">게스트</div>
					</div>
				`;
				listcount--;
			}
			bmiboard.innerHTML = result;
			return jsondata.page;//페이지 object 토스
		}).then((page) => {
			console.log(page);
			let pageButtnEle = document.getElementById('pageBoard');
			let i = 1;
			let result = ``;
			for(i; i<=page.totalpage; i++){
				result += `
					<div onclick="viewthispage(this)" data-nowpage="${i}">${i}</div>
				`;
			}
			pageButtnEle.innerHTML = result;
		});
	}
	getBMIlist();
	
	let getselectbmiList = (item) => {
		let itemvalue = item.value;
		console.log(itemvalue);
		let promise = new Promise((resolve, reject) => {
			
			let xhp = new XMLHttpRequest();
			xhp.open("GET", "/apiWeight/getBMIList?selectvalue="+itemvalue, true);
			xhp.send(null);
			
			xhp.onreadystatechange = () => {
				if(xhp.status === 200 && xhp.readyState === 4){
					resolve(xhp.responseText);
				}
			}			
			});
			
			promise.then((value) => {
			console.log(JSON.parse(value));
			let jsondata = JSON.parse(value);
			let listcount = jsondata.count;
			document.getElementById('countresult').innerHTML = listcount;
			let bmiboard = document.getElementById('bmiboard');
			let result = `
			<div class="bmi_list_item toplist">
				<div class="bmi_list_num bmi_top">Num</div>
				<div class="bmi_list_height bmi_top">키</div>
				<div class="bmi_list_weight bmi_top">몸무게</div>
				<div class="bmi_list_age bmi_top">나이</div>
				<div class="bmi_list_gender bmi_top">성별</div>
				<div class="bmi_list_BMI bmi_top">BMI</div>
				<div class="bmi_list_answer bmi_top">결과</div>
				<div class="bmi_list_date bmi_top">날짜</div>
				<div class="bmi_list_user bmi_top">유저</div>
			</div>
			`;
			for(let data of jsondata.list){
				
				let answercolor;
				if(data.bmi_status === "비만"){
					answercolor = "#ff0000";
				} else if (data.bmi_status === "과체중") {
					answercolor = "#b168ee";
				} else if (data.bmi_status === "정상") {
					answercolor = "#5cf928";
				} else if (data.bmi_status === "고도 비만")  {
					answercolor = "#ff2020";
				} else {
					answercolor = "#000000";
				}			
				
				result += `
					<div class="bmi_list_item">
						<div class="bmi_list_num">${listcount}</div>
						<div class="bmi_list_height">${data.height}</div>
						<div class="bmi_list_weight">${data.weight}</div>
						<div class="bmi_list_age">${data.age}</div>
						<div class="bmi_list_gender">${data.gender}</div>
						<div class="bmi_list_BMI">${data.bmi}</div>
						<div class="bmi_list_answer" style='color: ${answercolor}'>${data.bmi_status}</div>
						<div class="bmi_list_date">${data.uploadDate}</div>
						<div class="bmi_list_user">게스트</div>
					</div>
				`;
				listcount--;
			}
			bmiboard.innerHTML = result;
			});
		}
	
	let viewthispage = (item) => {
		let promise = new Promise((resolve,reject) => {
			let nowpage = item.getAttribute('data-nowpage'); 
			let pagecut = document.getElementById('pagecut').value;	
			
			let xhr = new XMLHttpRequest();
			xhr.open("GET", `/apiWeight/GetBMIListPage?pagecut=${pagecut}&nowpage=${nowpage}`, true);
			xhr.setRequestHeader("Content-Type","application/json; charset=UTF-8");
			xhr.send(null);
			xhr.onreadystatechange = () => {
				if(xhr.readyState === 4 && xhr.status === 200){
					resolve(xhr.responseText);
				}
			}
		});
		
		promise.then((value) => {
			console.log(JSON.parse(value));
			let jsondata = JSON.parse(value);
			let listcount = jsondata.count;
			document.getElementById('countresult').innerHTML = listcount;
			let bmiboard = document.getElementById('bmiboard');
			
			console.log(jsondata.count);
			console.log(jsondata.page.nowpage);
			console.log(jsondata.page.pagecut);
			
			let showcount = jsondata.count - ((jsondata.page.nowpage-1) * jsondata.page.pagecut);
			console.log(showcount);
			
			
			let result = `
			<div class="bmi_list_item toplist">
				<div class="bmi_list_num bmi_top">Num</div>
				<div class="bmi_list_height bmi_top">키</div>
				<div class="bmi_list_weight bmi_top">몸무게</div>
				<div class="bmi_list_age bmi_top">나이</div>
				<div class="bmi_list_gender bmi_top">성별</div>
				<div class="bmi_list_BMI bmi_top">BMI</div>
				<div class="bmi_list_answer bmi_top">결과</div>
				<div class="bmi_list_date bmi_top">날짜</div>
				<div class="bmi_list_user bmi_top">유저</div>
			</div>
			`;
			for(let data of jsondata.list){
				
				let answercolor;
				if(data.bmi_status === "비만"){
					answercolor = "#ff0000";
				} else if (data.bmi_status === "과체중") {
					answercolor = "#b168ee";
				} else if (data.bmi_status === "정상") {
					answercolor = "#5cf928";
				} else if (data.bmi_status === "고도 비만")  {
					answercolor = "#ff2020";
				} else {
					answercolor = "#000000";
				}			
				
				result += `
					<div class="bmi_list_item">
						<div class="bmi_list_num">${showcount}</div>
						<div class="bmi_list_height">${data.height}</div>
						<div class="bmi_list_weight">${data.weight}</div>
						<div class="bmi_list_age">${data.age}</div>
						<div class="bmi_list_gender">${data.gender}</div>
						<div class="bmi_list_BMI">${data.bmi}</div>
						<div class="bmi_list_answer" style='color: ${answercolor}'>${data.bmi_status}</div>
						<div class="bmi_list_date">${data.uploadDate}</div>
						<div class="bmi_list_user">게스트</div>
					</div>
				`;
				showcount--;
			}
			bmiboard.innerHTML = result;
			return jsondata.page;
		}).then((page) => {
			console.log(page);
			let pageButtnEle = document.getElementById('pageBoard');
			let i = 1;
			let result = ``;
			for(i; i<=page.totalpage; i++){
				result += `
					<div onclick="viewthispage(this)" data-nowpage="${i}">${i}</div>
				`;
			}
			pageButtnEle.innerHTML = result;
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	