package br.com.llpradela.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.llpradela.jpa.modelo.Movimentacao;

public class TestaSomaMovimentacoes {
	
	//exemplo de criteria API
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		//criacao do Criteria Builder  (vinda do entityManager)...
		CriteriaBuilder builder = em.getCriteriaBuilder();
		//...e da Criteria QUery (vinda do Builder da Criteria)
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		//semelhante a escrever "select * from movimentacao"
		//o root serve para pegar o objeto de retorno da query (sobre qual objeto é a query)
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		//Criacao da clusula sum(valor)
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		
		//insere a clausula sum no select, tornando select sum(valor) from movimentacao
		query.select(sum);
		
		//Manda a query para a conexao com a base de dados e retorna um unico valor (soma de valor)
		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		System.out.println("A média de movimentações é: " + typedQuery.getSingleResult());

	}
}
