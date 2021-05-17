function gerarHashEstoque(){
	let txt = "EST";
	let aleatorio = Math.floor(Math.random() * 150000000);
	document.getElementById('hash').value = (txt + aleatorio);
}