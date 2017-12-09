package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaBancos implements Desconto{

	@Override
	public BigDecimal aplicarDescontosSobre(BigDecimal precoOriginal) {
		
		return precoOriginal.subtract(trintaPorCentoSobre(precoOriginal));
		
	}

	private BigDecimal trintaPorCentoSobre(BigDecimal precoOriginal) {
		return precoOriginal.multiply(new BigDecimal("0.3"));
	}

	@Override
	public String getDecricao() {
		// TODO Auto-generated method stub
		return "Desconto Banco";
	}

}
