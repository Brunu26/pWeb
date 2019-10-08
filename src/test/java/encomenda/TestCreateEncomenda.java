package encomenda;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import exceptions.EncomendNotFoundException;
import model.bean.Encomenda;
import model.bean.Endereco;
import model.bean.Franquia;
import model.dao.encomenda.CreateEncomenda;
import model.dao.encomenda.DeleteEncomenda;
import model.dao.encomenda.SelectEncomenda;
import model.dao.franquia.SelectFranquia;

public class TestCreateEncomenda {

	private Encomenda encomenda, enc;
	private Franquia fr1, fr2;
	private Endereco ende, ende2;
	@Before
	public void setUp() throws SQLException {
		DeleteEncomenda.delete();
		ende = new Endereco("NE", "PB", "JP", "azul", 56);
		ende2 = new Endereco("NE", "PB", "CG", "sol", 12);
		fr1 = new Franquia("fr1", ende, false);
		fr2 = new Franquia("fr2", ende2, true);
		encomenda = new Encomenda("tpo1", fr1, fr2, ende);
		enc = new Encomenda("tpo2", fr1, fr2, ende2);
		CreateEncomenda.create(enc, fr1, fr2);
	}
	
	/**
	 * Teste para criação de encomendas
	 * @throws Exception
	 */
	@Test
	public void testCreate() throws Exception {
		assertEquals(true, CreateEncomenda.create(encomenda, fr1, fr2));
	}
	
	/**
	 * Teste para pesquisar de Encomendas cadastradas
	 * @throws Exception
	 */
	@Test
	public void testSelect() throws Exception {
		assertEquals(true, SelectEncomenda.select("tpo2"));
	}
	/**
	 * Teste para pesquisar de Encomendas não cadastradas
	 * @throws Exception
	 */
	@Test(expected=EncomendNotFoundException.class)
	public void testSelectNotFound() throws Exception {
		assertEquals(true, SelectEncomenda.select("tpo3"));
	}
}
