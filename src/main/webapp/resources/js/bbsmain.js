/**
 * 
 */

	console.log("bbsmain");
	
	let goboard = (item) => {
		console.log(item.id);
		let value = item.id;
		location.href="/bbs/"+value;
		
	}