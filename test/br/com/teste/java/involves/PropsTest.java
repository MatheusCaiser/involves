package br.com.teste.java.involves;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PropsTest {

	@Test
	public void testGetString() {
		assertEquals(Props.getString("unknown"), null);
		assertEquals(Props.getString("csvFile"), "cidades.csv");
		assertEquals(Props.getString("errorFileNotFound"), "Arquivo CSV não encontrado, certifique que ele está presenta na pasta");
	}

}
