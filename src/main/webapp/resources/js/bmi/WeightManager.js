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
		
		/*let docinput = document.querySelectorAll('input');
		
		for(let i of docinput) {
			if(i.value === "" || i.value == null){
				alert(`${i.placeholder} 를 입력하여주세요`);
				return;
			}
		}*/
		
		let data = {weight:weight, height:height, age:age, gender:gender, user:sessionStorage.getItem("sessionNickName") == null ? "게스트":'sessionStorage.getItem("sessionNickName")'}
		
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
						<div class="bmi_INFO">
							<div class="bmi_INFO_Height">
								<span>키</span>
								<span>${jsonData.height}</span>
							</div>
							<div class="bmi_INFO_Weight">
								<span>몸무게</span>
								<span>${jsonData.weight}</span>
							</div>
							<div class="bmi_INFO_BMI">
								<span>BMI</span>
								<span>${jsonData.bmi}</span>
							</div>
						</div>
						<div class="bmi_Result">
							<div class="bmi_Result_text">결과</div>
							<div id="answer" class="bmi_Result_answer">${jsonData.bmi_status}</div>
							<div class="bmi_Result_comment">건강이 위험해요</div>
						</div>
				`;
				resultboard.innerHTML = result;
				resultboard.style.opacity = 1;
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
				document.getElementById('answer').style.color = answercolor;
				document.getElementById('WeightButton').style.pointerEvents = "none";
			}
		}
	});
	

