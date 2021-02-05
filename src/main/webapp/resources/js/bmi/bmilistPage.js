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
			let bmiboard = document.getElementById('bmiboard');
			let result = `
			<div class="bmi_list_item toplist">
				<div class="bmi_list_num bmi_top">Num</div>
				<div class="bmi_list_height bmi_top">키</div>
				<div class="bmi_list_weight bmi_top">몸무게</div>
				<div class="bmi_list_BMI bmi_top">BMI</div>
				<div class="bmi_list_answer bmi_top">결과</div>
				<div class="bmi_list_date bmi_top">날짜</div>
				<div class="bmi_list_user bmi_top">유저</div>
			</div>
			`;
			for(let data of jsondata.list){
				result += `
					<div class="bmi_list_item">
						<div class="bmi_list_num">${listcount}</div>
						<div class="bmi_list_height">${data.height}</div>
						<div class="bmi_list_weight">${data.weight}</div>
						<div class="bmi_list_BMI">${data.bmi}</div>
						<div class="bmi_list_answer">${data.bmi_status}</div>
						<div class="bmi_list_date">${data.stringdate}</div>
						<div class="bmi_list_user">게스트</div>
					</div>
				`;
				listcount--;
			}
			bmiboard.innerHTML = result;
		});
	}
	getBMIlist();