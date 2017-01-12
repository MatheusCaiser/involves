package br.com.teste.java.involves.command;

public enum CommandEnum {
	unknown(-1, "unknown", "Comando não reconhecido"), //
	count(1, "count", "Uso: count [*] [distinct <property>]\n\t * \tretorna o número total de registros"
			+ "\n\t distinct <property> \tretorna o número de resgistros distintos referente a propriedade passada em [property]"), //
	filter(2, "filter", "Uso: filter [property <value>]\n\tRetorna os registros filtrados pelos parametros passados"), //
	quit(3, "quit", "Finaliza o programa");

	int index;
	String command;
	String description;

	CommandEnum(int index, String command, String descricao) {
		this.index = index;
		this.command = command;
		this.description = descricao;
	}

	public int getIndex() {
		return this.index;
	}

	public String getCommand() {
		return this.command;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descricao) {
		this.description = descricao;
	}
	
}
