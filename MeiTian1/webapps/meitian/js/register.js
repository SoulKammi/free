
function displayinfo(){
	var obj = event.target||event.srcElement;
	
	if(obj.nodeName=="INPUT"){
		
		var parent = obj.parentNode;
		
		var span = parent.childNodes[2];
		span.innerText = "请输入6到12字符";
		span.style.display="inline-block";
	}
}

function check(){
	
	var obj = event.target||event.srcElement;
	console.log("123");
	var reg = /^\w{6-18}$/;
	if(obj.nodeName=="INPUT"){
		console.log(obj.value);
		if(reg.test(obj.value)){
			var parent = obj.parentNode;	
			var span = parent.childNodes[2];
			span.innerText = "输入正确";
			span.style.color="green";
		}
		
	}
	
}