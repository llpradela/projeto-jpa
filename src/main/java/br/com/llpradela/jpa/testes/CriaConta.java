package br.com.llpradela.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.llpradela.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("OUTRO TESTE");
		conta.setNumero(1555);
		conta.setAgencia(88);

		em.getTransaction().begin();
		em.persist(conta); // nesse momento o objeto conta se torna managed (sincronizado com um banco
							// relacional
		em.getTransaction().commit();
	}
}
