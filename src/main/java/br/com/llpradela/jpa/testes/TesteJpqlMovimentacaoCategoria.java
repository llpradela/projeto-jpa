package br.com.llpradela.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.llpradela.jpa.modelo.Categoria;
import br.com.llpradela.jpa.modelo.Movimentacao;

public class TesteJpqlMovimentacaoCategoria {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		// dois pontos (:) serve para identificar 	o objeto
		String jpql = "select m from Movimentacao m" 
				+ " join m.categoria c "
				+ " where c = :pCategoria"; 

		Categoria pCategoria = new Categoria();
		pCategoria.setId(1L);
		//tipar a query é o correto a ser feito (apenas Query apresenta warning)
		TypedQuery<Movimentacao> query = em.createQuery(jpql,Movimentacao.class);
		//por conveção, sempre insira p antes do nome do objeto de parametro
		query.setParameter("pCategoria", pCategoria); // passar a conta como parametro
		List<Movimentacao> resultList = query.getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println("Categorias: " + movimentacao.getCategoria());
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
	}
}	  