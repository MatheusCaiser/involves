package br.com.teste.java.involves;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CSVReaderTest {

	private CSVReader reader;

	@Before
	public void setUp() throws Exception {
		reader = new CSVReader(Props.getString("csvFile"), ",");
	}

	@Test
	public void testHasProperty() {
		assertTrue(reader.hasProperty("capital"));
		assertTrue(reader.hasProperty("uf"));
		assertFalse(reader.hasProperty("fase"));
		assertFalse(reader.hasProperty("middle"));
	}

	@Test
	public void testGetHeaderPosition() {
		assertEquals(0, reader.getHeaderPosition("ibge_id"));
		assertEquals(9, reader.getHeaderPosition("mesoregion"));
		assertEquals(6, reader.getHeaderPosition("no_accents"));
		assertEquals(2, reader.getHeaderPosition("name"));
	}

	@Test
	public void testGetLinesWith() {
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("3550308 | SP | São Paulo | true | -46.5703831821 | -23.5673865 | Sao Paulo |  | São Paulo | Metropolitana de São Paulo");
		assertEquals(expectedResult , reader.getLinesWith("name", "São Paulo"));
	}

}
