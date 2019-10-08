package franquia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.bean.Endereco;
import model.bean.Franquia;

public class TestEnderecoFranquia {
	
	Endereco ender;
	Endereco ender2;
	Franquia franq;
	Franquia franq2;
	
	@Before
	public void setup() {
		ender = new Endereco("regiao", "estado", "cidade", "rua", 5);
		franq = new Franquia("Numero 1",ender, true);

		ender2 = new Endereco("regiao 2", "estado 2", "cidade 2", "rua 2", 10);
		franq2 = new Franquia("Numero 2",ender2, false);
	}
	
	@Test
	public void testEnderecoCompleto() {
		assertEquals(franq.getEndereco().enderCompleto(), ender.enderCompleto());
		assertEquals(franq2.getEndereco().enderCompleto(), ender2.enderCompleto());
	}
	
	@Test
	public void testEnderecoCidade() {
		assertEquals(franq.getEndereco().enderCidade(), ender.enderCidade());
		assertEquals(franq2.getEndereco().enderCidade(), ender2.enderCidade());
	}
	
	@Test
	public void testEnderecoRegiao() {
		assertEquals(franq.getEndereco().enderRegiao(), ender.enderRegiao());
		assertEquals(franq2.getEndereco().enderRegiao(), ender2.enderRegiao());
	}
}
