package br.com.teste.java.involves.command;

import br.com.teste.java.involves.CSVReader;

public interface Command {
	/**
	 * Executa comando conforme a especifica��o.
	 * 
	 * @param reader
	 * @param args
	 */
	void execute(CSVReader reader, String ...args);
}
