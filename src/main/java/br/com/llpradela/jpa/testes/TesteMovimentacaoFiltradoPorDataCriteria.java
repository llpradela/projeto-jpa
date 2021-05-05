package br.com.llpradela.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.llpradela.jpa.dao.MovimentacaoDao;
import br.com.llpradela.jpa.modelo.Movimentacao;

public class TesteMovimentacaoFiltradoPorDataCriteria {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		MovimentacaoDao dao = new MovimentacaoDao(em);
		List<Movimentacao> movimentacoesFiltradasPorData = dao.getMovimentacoesFiltradasPorData(26, null, 2021);
		for (Movimentacao movimentacao : movimentacoesFiltradasPorData) {
			System.out.println("Movimentacao -> " + movimentacao.getDescricao());
			System.out.println("Valor -> " + movimentacao.getValor());
			System.out.println("Descrição -> " + movimentacao.getDescricao());
			System.out.println("Data -> " + movimentacao.getData());
			System.out.println("---------------------------------------");
		}
	}
}