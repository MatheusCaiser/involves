package br.com.teste.java.involves.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.teste.java.involves.CSVReader;
import br.com.teste.java.involves.Props;
import br.com.teste.java.involves.utils.StringUtils;

public class FilterCommandTest {
	
	private static final String COMMA = ",";
	private static final String SPACE_BLANK = " ";
	private FilterCommand filterCommand;
	private CSVReader reader;

	@Before
	public void setUp() {
		filterCommand = new FilterCommand();
		reader = new CSVReader(Props.getString("csvFile"), COMMA);
	}

	@Test
	public void reconheceComandoFilter() {
		String comando = "filter uf ro";
		String[] args = StringUtils.stringToArray(comando, SPACE_BLANK);
		filterCommand.execute(reader, args);
		assertEquals(Result.filter, filterCommand.getResult());
	}
	
	@Test
	public void reconheceComandaFilterSemProperty() {
		String comando = "filter";
		String[] args = StringUtils.stringToArray(comando, COMMA);
		filterCommand.execute(reader, args);
		assertEquals(Result.filterWithoutProperty, filterCommand.getResult());
	}
}
