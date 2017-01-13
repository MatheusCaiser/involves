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
	
	private Result result;

	@Override
	public void execute(CSVReader reader, String... args) {
		if (args.length == 2) {
			if (args[1].equals("*")) {
				Console.info("Total de registros: " + (reader.countAll() - 1));
				this.result = Result.countAll;
			} else {
				if(args[1].equalsIgnoreCase("distinct")) {
					Console.info("Faltou informar o valor de [<property>]");
					this.result = Result.countDistinctWithoutProperty;
				} else {
					Console.info(CommandEnum.count.getDescription());
					this.result = Result.unknown;
				}
			}

		} else {
			if (args.length > 2) {
				String property = args[2];

				if (!reader.hasProperty(property)) {
					Console.error("A propriedade '" + property + "' não existe no arquivo");
					Console.out(reader.headersToString());
					this.result = Result.noHasProperty;
				} else {
					ArrayList<String> linesWithProperty = reader.readColumn(property, true);
					Console.info("Número de valores distintos de '" + property + "' no arquivo: " + linesWithProperty.size());
					this.result = Result.countDistinct;
				}
			} else {
				Console.info(CommandEnum.count.getDescription());
				this.result = Result.unknown;
			}
		}
	}

	public Result getResult() {
		return result;
	}
}
