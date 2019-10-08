package franquia;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.bean.Endereco;
import model.bean.Franquia;
import model.dao.franquia.CreateFranquia;
import model.dao.franquia.DeleteAll;
import model.dao.franquia.DeleteFranquia;
import model.dao.franquia.SelectFranquia;

public class TestCreateFranquia {
	
	private Endereco endereco,endereco2,endereco22;
	private Franquia franquia,franquia2,franquia4;
	private CreateFranquia create;
	private SelectFranquia select;
	private DeleteFranquia delete;
	@Before
	public void setUp() throws Exception {
		//DeleteAll.delete();
		endereco = new Endereco("regiao", "estado", "cidade", "2", 2);
		endereco2 = new Endereco("regiao", "estado", "cidade2", "2", 2);
		endereco22 = new Endereco("regiao", "estado", "cidade22", "2", 2);
		franquia = new Franquia("nome", endereco, true);
		franquia2 = new Franquia("nome2", endereco2, true);
		franquia4 = new Franquia("nome22", endereco22, true);
		create = new CreateFranquia();
		select = new SelectFranquia();
		delete = new DeleteFranquia();
		
	}
	
	@Test
	public void testCreate() throws Exception {
		assertEquals(true, create.create(franquia));
	}
	
	@Test
	public void testSelect() throws Exception {
		create.create(franquia2);
		assertEquals(franquia2.isMatriz(), select.select("nome2").isMatriz());
	}
	
	@Test
	public void testDelete() throws Exception{
		create.create(franquia4);
		assertEquals(true,delete.delete("nome22"));
	}
	
}	
