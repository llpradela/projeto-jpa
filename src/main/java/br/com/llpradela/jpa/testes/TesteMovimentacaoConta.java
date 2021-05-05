package br.com.llpradela.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.llpradela.jpa.modelo.Conta;
import br.com.llpradela.jpa.modelo.Movimentacao;

/**
 * Teste de relacionamento bilateral
 * @author Leandro Luiz Pradela
 *
 */
public class TesteMovimentacaoConta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Movimentacao movimentacao = em.find(Movimentacao.class, 2l);
		Conta conta = movimentacao.getConta();
		int qtdeMov = conta.getMovimentacoes().size();
		
		System.out.println("Quantidade de movimentações: " + qtdeMov);
		System.out.println("Titular da conta: " + conta.getTitular());
	}
}