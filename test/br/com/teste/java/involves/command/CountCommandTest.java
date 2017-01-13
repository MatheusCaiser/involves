package br.com.teste.java.involves.command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.teste.java.involves.CSVReader;
import br.com.teste.java.involves.Props;
import br.com.teste.java.involves.command.CountCommand;
import br.com.teste.java.involves.utils.StringUtils;

public class CountCommandTest {

	private static final String COMMA = ",";
	private static final String SPACE_BLANK = " ";
	private CountCommand countCommand;
	private CSVReader reader;

	@Before
	public void setUp() {
		countCommand = new CountCommand();
		reader = new CSVReader(Props.getString("csvFile"), COMMA);
	}

	@Test
	public void reconheceComandoCountTest() {
		String comando = "count *";
		String[] args = StringUtils.stringToArray(comando, SPACE_BLANK);
		countCommand.execute(reader, args);
		Assert.assertEquals(Result.countAll, countCommand.getResult());

	}

	@Test
	public void reconheceComandoDistinctCountSemPropertytTest() {
		String comando = "count distinct";
		String[] args = StringUtils.stringToArray(comando, SPACE_BLANK);
		countCommand.execute(reader, args);
		Assert.assertEquals(Result.countDistinctWithoutProperty, countCommand.getResult());
	}
	
	@Test
	public void reconheceComandoDistinctCount() {
		String comando = "count distinct uf";
		String[] args = StringUtils.stringToArray(comando, SPACE_BLANK);
		countCommand.execute(reader, args);
		Assert.assertEquals(Result.countDistinct, countCommand.getResult());
	}
}
