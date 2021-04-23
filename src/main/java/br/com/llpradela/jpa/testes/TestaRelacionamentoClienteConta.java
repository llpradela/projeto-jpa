package br.com.llpradela.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.llpradela.jpa.modelo.Cliente;
import br.com.llpradela.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(1l);
		
		Cliente cliente = new Cliente();
		cliente.setEndereco("Rua Tek");
		cliente.setNome("Dick");
		cliente.setProfissao("dev");	
		cliente.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}