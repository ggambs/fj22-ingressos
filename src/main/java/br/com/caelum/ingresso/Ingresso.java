package br.com.caelum.ingresso;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;
import br.com.caelum.ingresso.model.descontos.Desconto;

@Entity
public class Ingresso {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Sessao sessao;
	
	private BigDecimal preco;
	
	@ManyToOne
	private Lugar lugar;
	
	
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;
	
	public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar){
		this.sessao = sessao;
		this.tipoDeIngresso = tipoDeIngresso;
		this.preco = this.tipoDeIngresso.aplicaDesconto(sessao.getPreco());
		
		this.lugar = lugar;
	}
	
	
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


	public Lugar getLugar() {
		return lugar;
	}


	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}


	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}


	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}


	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
