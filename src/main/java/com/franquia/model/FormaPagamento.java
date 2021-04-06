package com.franquia.model;

import javax.persistence.Column;

public enum FormaPagamento {
	
	PIX("pix"),
	CREDITO("credito"),
	DEBITO("debito"),
	BOLETO("boleto"),
	AVISTA("avista");
	
	@Column(name = "forma_pagamento")
	private String forma_pagamento;
	// Atributo referente a model 
	
	private FormaPagamento (String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

}
