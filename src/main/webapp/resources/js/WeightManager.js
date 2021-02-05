/**
 * 
 */

	let sendbutton = document.getElementById('WeightButton');	
	sendbutton.addEventListener("click",(e)=>{
		e.preventDefault();
		
		let weight = document.getElementById('weight').value;
		let height = document.getElementById('height').value;
		let age = document.getElementById('age').value;
		let gender = document.querySelector('input[id="gender"]:checked').value;
		
		let docinput = document.querySelectorAll('input');
		
		for(let i of docinput) {
			if(i.value === "" || i.value == null){
				alert(`${i.placeholder} 를 입력하여주세요`);
				return;
			}
		}
		
		let data = {weight:weight, height:height, age:age, gender:gender}
		
		let xhp = new XMLHttpRequest();
		xhp.open("POST", "/apiWeight/insertWeight", true);
		xhp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
		xhp.send(JSON.stringify(data));
		xhp.onreadystatechange = () => {
			if(xhp.readyState === 4 && xhp.status === 200){
				let jsonData = JSON.parse(xhp.responseText);
				console.log(jsonData);
				let resultboard = document.getElementById('resultBoard');
				let result = "";
				result += `
					<div>
						<div>키 : ${jsonData.height}</div>
						<div>몸무게 : ${jsonData.weight}</div>
						<div>BMI : ${jsonData.bmi}</div>
					</div>
					<div>
						<div>어쩌구 저쩌구입니다.</div>
					</div>
				`;
				resultboard.innerHTML = result;
			}
		}
	});
	

