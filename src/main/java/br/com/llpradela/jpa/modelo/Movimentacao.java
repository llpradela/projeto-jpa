package br.com.llpradela.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NamedQuery;

import br.com.llpradela.jpa.constant.TipoMovimentacao;

@NamedQuery(name="mediaComDataMovimentacao", query=
"select new br.com.llpradela.jpa.modelo.MediaComData("
+ "day(m.data), month(m.data), avg(m.valor)) "
+ " from Movimentacao m group by day(m.data), month(m.data), year(m.data)")

@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	private BigDecimal valor;
	private LocalDateTime data;
	private String descricao;

	@ManyToOne // varias Movimentações para uma unica Conta
	private Conta conta;

	@ManyToMany //X movimentacoes podem ter X categorias
	private List<Categoria> categoria;
	
	@Override
	public String toString() {
		return this.getDescricao() + ":" + this.getValor();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
}