package br.com.llpradela.jpa.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.llpradela.jpa.modelo.MediaComData;
import br.com.llpradela.jpa.modelo.Movimentacao;

public class MovimentacaoDao {

	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	// criteria API
	public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer dia, Integer mes, Integer ano) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);

		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		List<Predicate> listPred = new ArrayList<Predicate>();
		if (dia != null) {
			//isso é semelhante a dizer "and day(data) = dia"
			Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), dia);
			listPred.add(predicate);
		}

		if (mes != null) {
			Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), mes);
			listPred.add(predicate);
		}

		if (ano != null) {
			Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), ano);
			listPred.add(predicate);
		}
		
		//essa linha cria um array de Predicate vazio e depois insere os Predicate do listPred nele
		query.where((Predicate[]) listPred.toArray(new Predicate[0]));

		TypedQuery<Movimentacao> typedQuery = em.createQuery(query);
		return typedQuery.getResultList();
	}

	public List<MediaComData> getMediaComDataMovimentacoes() {

		// chamar NamedQuery (bem legal)
		TypedQuery queryMedia = em.createNamedQuery("mediaComDataMovimentacao", MediaComData.class);
		return queryMedia.getResultList();
	}

	public Double getSomaMovimentacoes() {

		String jpqlSoma = "select SUM(m.valor) from Movimentacao m";
		TypedQuery<BigDecimal> querySoma = em.createQuery(jpqlSoma, BigDecimal.class);
		BigDecimal soma = querySoma.getSingleResult();

		System.out.println("O total de movimentações é: " + soma);

		String jpqlMedia = "select AVG(m.valor) from Movimentacao m";
		TypedQuery<Double> queryMedia = em.createQuery(jpqlMedia, Double.class);
		return queryMedia.getSingleResult();
	}
}
