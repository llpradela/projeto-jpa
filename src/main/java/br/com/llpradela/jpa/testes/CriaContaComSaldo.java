package br.com.llpradela.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.llpradela.jpa.modelo.Conta;

public class CriaContaComSaldo {

public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Luciana");
		conta.setNumero(9857);
		conta.setAgencia(7777);
		conta.setSaldo(12.55);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close(); //aqui o objeto deixou de ser managed e se torna detached
		
		EntityManager em2 = emf.createEntityManager();
		conta.setSaldo(10000.99); //alteração em um objeto detached
	
		em2.getTransaction().begin();
		em2.merge(conta); //merge pega um objeto detached é retorna ela a estado managed
		em2.getTransaction().commit();
	}
}
