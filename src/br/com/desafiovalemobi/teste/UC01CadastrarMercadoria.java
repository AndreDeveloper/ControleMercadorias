package br.com.desafiovalemobi.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.desafiovalemobi.infrastructure.DAO;
import br.com.desafiovalemobi.infrastructure.MercadoriaDAO;
import br.com.desafiovalemobi.model.Mercadoria;

public class UC01CadastrarMercadoria {
	private static DAO dao;
	private static Mercadoria mercadoria;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = MercadoriaDAO.getInstance();
		mercadoria = new Mercadoria();
		mercadoria.setCodigo(1);
		mercadoria.setNegocio("A");
		mercadoria.setNome("A");
		mercadoria.setPreco(30);
		mercadoria.setQuantidade(1);
		mercadoria.setTipo("A");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@After
	public void excluir(){
		dao.delete(mercadoria);
	}
	@Test
	public void CT01UC01CadastrarMercadoria() {
		assertEquals(true,dao.insert(mercadoria));
	}
}
