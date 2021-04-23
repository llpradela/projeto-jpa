package br.com.llpradela.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.llpradela.jpa.constant.TipoMovimentacao;
import br.com.llpradela.jpa.modelo.Conta;
import br.com.llpradela.jpa.modelo.Movimentacao;

public class TestaRelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia(999);
		conta.setNumero(555);
		conta.setSaldo(200.50);
		conta.setTitular("Rogerio");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setValor(new BigDecimal(150.22));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);//precisa persistir a conta antes para que ela se torne Managed
		em.persist(movimentacao);//persiste a movimentacao
		em.getTransaction().commit();
		
		em.close();
	}
}
