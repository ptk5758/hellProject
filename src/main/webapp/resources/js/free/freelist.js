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
	
	promise.then((res) => {
		console.log(res);
	});