package br.com.llpradela.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.llpradela.jpa.modelo.Conta;
import br.com.llpradela.jpa.modelo.Movimentacao;

//importações omitidas

public class TesteJPQL { // JPQL siginifica escrever as querys com os objetos (Conta, em vez de
							// ttlr_Conta)
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setId(2L);
		String jpql = "select m from Movimentacao m where m.conta = :pConta order by valor desc"; // dois pontos (:) serve para identificar
																				// o objeto
		
		//tipar a query é o correto a ser feito (apenas Query apresenta warning)
		TypedQuery<Movimentacao> query = em.createQuery(jpql,Movimentacao.class);
		//por conveção, sempre insira p antes do nome do objeto de parametro
		query.setParameter("pConta", conta); // passar a conta como parametro
		List<Movimentacao> resultList = query.getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
	}
}
