
reduce=	function () {
	var amount = document.getElementById('amount').innerText;
	if (amount >1 ) {
			amount--;
			//计算价格
		document.getElementById('amount').innerText = amount;
	}
	
}
add=function () {
	var amount = document.getElementById('amount').innerText;
		amount++;
		console.log(amount)
	document.getElementById('amount').innerText = amount;
}