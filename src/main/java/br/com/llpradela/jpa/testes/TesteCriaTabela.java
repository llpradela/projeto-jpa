package br.com.llpradela.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabela {

	public static void main(String[] args) {
		//criando a fabrica de JPA utilizando o arquivo persistence
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = emf.createEntityManager();
		emf.close(); //fecha a fabrica	
		
		//irá criar a tabela Conta, caso não tenha a tabela Conta
	}
}