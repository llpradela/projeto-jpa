package br.com.llpradela.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.llpradela.jpa.modelo.Conta;

public class AtualizaContaSaldo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta contaLeandro = em.find(Conta.class, 3l);
		System.out.println("CONTA DO... " + contaLeandro.getTitular());
		
		em.getTransaction().begin();
		contaLeandro.setSaldo(880.50);
		em.getTransaction().commit();
		em.close();
	}
}
