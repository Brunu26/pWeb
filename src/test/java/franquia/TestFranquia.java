package franquia;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exceptions.FranquiaNotFoundException;
import model.bean.Endereco;
import model.bean.Franquia;
import model.dao.franquia.CreateFranquia;
import model.dao.franquia.UpdateFranquia;

public class TestFranquia {
	
	Endereco ender;
	Endereco ender2;
	private Franquia franq;
	private Franquia franq2;
	private UpdateFranquia update;
	
	@Before
	public void setup() throws Exception{
		ender = new Endereco("regiao", "estado", "cidade", "rua", 5);
		franq = new Franquia("Numero 1",ender, true);

		update = new UpdateFranquia();
		ender2 = new Endereco("regiao 2", "estado 2", "cidade 2", "rua 2", 10);
		franq2 = new Franquia("Numero 2",ender2, false);

	}
	
	/**
	 * Testando recebendo nome da franquia
	 */
	@Test
	public void testNome() {
		assertEquals("Numero 1", franq.getNome());
		assertEquals("Numero 2", franq2.getNome());
	}
	
	/**
	 * Teste para verificação se a franquia é matriz
	 */
	@Test
	public void testMatriz() {
		assertEquals(franq.isMatriz(), true);
		assertEquals(franq2.isMatriz(), false);
	}
	
	/**
	 * Teste para atualização de franquia não cadastrada
	 * @throws Exception
	 */
	@Test(expected=FranquiaNotFoundException.class)
	public void testUpdateNot() throws Exception {
		assertEquals(true,update.updateNome("Numero 11", "trocado"));
	}

}
