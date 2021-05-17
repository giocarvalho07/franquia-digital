function gerarHashEstoque(){
	let txt = "EST";
	let aleatorio = Math.floor(Math.random() * 150000000);
	document.getElementById('hash').value = (txt + aleatorio);
}


function gerarHashFornecedor(){
	let txt = "FOR";
	let aleatorio = Math.floor(Math.random() * 200000000);
	document.getElementById('hashMarca').value = (txt + aleatorio);
}