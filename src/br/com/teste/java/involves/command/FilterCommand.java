package br.com.teste.java.involves.command;

import java.util.ArrayList;

import br.com.teste.java.involves.CSVReader;
import br.com.teste.java.involves.console.Console;

/**
 * <p>
 * Realiza filtro de dados conforme o argumento passado.
 * 
 * O parametro passado em args é checado e tratado conforme seu tamanho.
 * 
 * Caso o tamanho do array for maior que dois (2) é reconhecido as palavras
 * passadas no input do console para comando <i>filter [property] [value]</i>.
 * </p>
 * 
 * O terceiro parametro é tratado caso acha mais de uma palavra como em cidades
 * com mais nomes <br>
 * Ex: Porto Velho
 * 
 * @author Matheus Henrique Caiser
 *
 */
public class FilterCommand implements Command {
	private Result result;

	public void execute(CSVReader reader, String... args) {
		String property;
		String value;

		if (args.length > 2) {
			property = args[1];
			value = args[2];

			if (args.length > 2) {
				for (int i = 3; i < args.length; i++) {
					value += " " + args[i];
				}
			}

			if (!reader.hasProperty(property)) {
				Console.error("A propriedade '" + property + "' não existe no arquivo");
				Console.out(reader.headersToString());
				this.result = Result.noHasProperty;
			} else {
				ArrayList<String> filterDistinctLines = reader.getLinesWith(property, value);
				String[] header = reader.getHeader();

				if (filterDistinctLines.size() > 0) {
					String headerString = "\n";
					for (String currentHeader : header) {
						headerString += currentHeader + " | ";
					}
					headerString = headerString.trim();
					headerString = headerString.substring(0, headerString.length() - 1);
					Console.out(headerString + "\n");

					for (String currentLine : filterDistinctLines) {
						Console.out(currentLine + "\n");
					}
					this.result = Result.filter;
				} else {
					Console.info("Não foi encontrado nenhum valor em '" + property + "' como '" + value + "'");
					this.result = Result.valueNotFoundInProperty;
				}
			}
		} else {
			Console.out(CommandEnum.filter.getDescription());
			Console.error("Você deve informar um valor para filtrar");
			this.result = Result.filterWithoutProperty;
		}

	}

	public Result getResult() {
		return result;
	}

}
