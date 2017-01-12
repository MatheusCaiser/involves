package br.com.teste.java.involves.principal;


import br.com.teste.java.involves.CSVReader;
import br.com.teste.java.involves.command.CommandEnum;
import br.com.teste.java.involves.console.Console;
import br.com.teste.java.involves.console.Interpreter;

public class Principal {
	private static final String COMMA = ",";
	private Interpreter interpreter;
	
	public Principal(String csvFile) {
		this.interpreter = new Interpreter(new CSVReader(csvFile, COMMA));
	}

	public void initialize() {
		int index = -1;
		Console.welcomeMsg();
		
		while(index  != CommandEnum.quit.getIndex()) {
			index = interpreter.interpret();
		}
	}
}
