package br.com.llpradela.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.llpradela.jpa.dao.MovimentacaoDao;
import br.com.llpradela.jpa.modelo.MediaComData;

public class TesteMediaDiariaMovimentacoes {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = emf.createEntityManager();

		List<MediaComData> media = new MovimentacaoDao(createEntityManager).getMediaComDataMovimentacoes();
		for (MediaComData resultados : media) {
			System.out.println("A m�dia de movimenta��es do dia " + resultados.getDia() + " do m�s "
					+ resultados.getMes() + " �: " + resultados.getValor());
		}
	}
}
