package br.com.teste.java.involves.command;

import br.com.teste.java.involves.CSVReader;

public class QuitCommand implements Command {

	@Override
	public void execute(CSVReader reader, String... args) {
		System.out.println("\nPrograma finalizado com sucesso. \n");
		System.exit(0);
	}

}
