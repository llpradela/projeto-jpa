package br.com.llpradela.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.llpradela.jpa.modelo.Conta;

public class TesteEstados {

	public static void main(String[] args) {
		
		//o estado do objeto que é possivel candidato a ser Managed se chama Transient
		Conta conta = new Conta();
		conta.setAgencia(123);
		conta.setTitular("Fernando");
		conta.setAgencia(999);
		conta.setNumero(699877);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//transformando Transient em managed
		em.persist(conta);
		
		//chamar o remove transforma o objeto em estado removed
		em.remove(conta);
		
		em.getTransaction().commit();
	}
}
