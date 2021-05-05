 package br.com.llpradela.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.llpradela.jpa.constant.TipoMovimentacao;
import br.com.llpradela.jpa.modelo.Categoria;
import br.com.llpradela.jpa.modelo.Conta;
import br.com.llpradela.jpa.modelo.Movimentacao;

public class TesteRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocios");
		
		Conta conta = new Conta();
		conta.setId(1l);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem a sergipe");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(699.0));
		//método que insere uma lista de categorias
		movimentacao.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta); 
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem ao parana");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now().plusDays(1));
		movimentacao2.setValor(new BigDecimal(22.0));
		//método que insere uma lista de categorias
		movimentacao2 .setCategoria(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta); 
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(categoria2);
		
		em.persist(movimentacao);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
	}
}
