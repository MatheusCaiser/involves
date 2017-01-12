package br.com.teste.java.involves.console;

import java.util.Scanner;

import br.com.teste.java.involves.CSVReader;
import br.com.teste.java.involves.command.Command;
import br.com.teste.java.involves.command.CommandEnum;
import br.com.teste.java.involves.command.CountCommand;
import br.com.teste.java.involves.command.FilterCommand;
import br.com.teste.java.involves.command.QuitCommand;
import br.com.teste.java.involves.utils.StringUtils;

public class Interpreter {
	private static final String SPACE_BLANK = " ";
	CommandEnum commandEnum;

	private Scanner scanner;
	private CSVReader reader;

	public Interpreter(CSVReader reader) {
		this.reader = reader;
	}

	private String getInput() {
		Console.out("$ ");
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	private CommandEnum getCommand(String cmd) {
		if (CommandEnum.count.getCommand().equalsIgnoreCase(cmd)) {
			return CommandEnum.count;
		} else if (CommandEnum.filter.getCommand().equalsIgnoreCase(cmd)) {
			return CommandEnum.filter;
		} else if (CommandEnum.quit.getCommand().equalsIgnoreCase(cmd)) {
			return CommandEnum.quit;
		}

		return CommandEnum.unknown;
	}

	public int interpret() {
		Command command = null;
		String[] inputArray = StringUtils.stringToArray(getInput(), SPACE_BLANK);
		String cmd = inputArray[0];
		commandEnum = getCommand(cmd);

		switch (commandEnum) {
		case count:
			command = new CountCommand();
			break;
		case filter:
			command = new FilterCommand();
			break;
		case quit:
			command = new QuitCommand();
			break;
		case unknown:
			Console.error("O comando '" + cmd + "' não é reconhecido");
			break;
		}

		if (command != null)
			command.execute(reader, inputArray);

		return commandEnum.getIndex();
	}

}
