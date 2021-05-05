package br.com.llpradela.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.llpradela.jpa.modelo.Conta;

public class TestaRelatorioMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//utilizar o join fetch melhora a performance de uma query N +1
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
		
		List<Conta> resultList = query.getResultList();
		for (Conta conta : resultList) {
			System.out.println("titular: " + conta.getTitular());
			System.out.println("agencia: " + conta.getAgencia());
			System.out.println("numero: " + conta.getNumero());
			System.out.println("movimentacoes: " + conta.getMovimentacoes());
		}
		
	}
}
