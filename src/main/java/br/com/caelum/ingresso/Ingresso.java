package br.com.caelum.ingresso;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.descontos.Desconto;

public class Ingresso {
	
	private Sessao sessao;
	private BigDecimal preco;
	
	
	/**
	 * 
	 * @deprecated hibernate only
	 * 
	 */
	public Ingresso(){
		
		
	}
	
	public Ingresso(Sessao sessao, Desconto tipoDeDesconto){
		this.sessao = sessao;
		this.preco = tipoDeDesconto.aplicarDescontosSobre(sessao.getPreco());
		
	}
	
	public Sessao getSessao(){
		return sessao;
	}
	
	public BigDecimal getPreco(){
		return preco;
	}

}
