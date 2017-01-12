package br.com.teste.java.involves.command;



import java.util.ArrayList;

import br.com.teste.java.involves.CSVReader;
import br.com.teste.java.involves.console.Console;

/**
 * Realiza a contagem de registros no arquivo
 * 
 * Se count vier seguido de <i>distinct</i> é reconhecido o requerimento <i>property</i>
 * Comando count [*] [distinct] [property]
 * @author Matheus Henrique Caiser
 *
 */
public class CountCommand implements Command {

	@Override
	public void execute(CSVReader reader, String... args) {
		if (args.length == 2) {
			if (args[1].equals("*")) {
				Console.info("Total de registros: " + (reader.countAll() - 1));
			} else {
				if(args[1].equalsIgnoreCase("distinct")) {
					Console.info("Faltou informar o valor de [<property>]");
				} else {
					Console.info(CommandEnum.count.getDescription());
				}
			}

		} else {
			if (args.length > 2) {
				String property = args[2];

				if (!reader.hasProperty(property)) {
					Console.error("A propriedade '" + property + "' não existe no arquivo");
					Console.out(reader.headersToString());
				} else {
					ArrayList<String> linesWithProperty = reader.readColumn(property, true);
					Console.info("Número de valores distintos de '" + property + "' no arquivo: " + linesWithProperty.size());
				}
			} else {
				Console.info(CommandEnum.count.getDescription());
			}
		}
	}
}
