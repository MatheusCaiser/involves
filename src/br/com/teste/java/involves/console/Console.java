package br.com.teste.java.involves.console;

/**
 * Classe responsável pela parte de log no console
 * @author Matheus Caiser Barrozo
 *
 */
public class Console {
	
	public static void log(String text, int level) {
		if (level == 0) {
			System.out.print(text);
		} else {
			System.err.println(text);
		}
	}
	
	public static void out(String out) {
		log(out, 0);
	}

	public static void error(String msg) {
		log("\n[ Erro ] " + msg + "\n", 1);
	}
	
	public static void info(String msg) {
		out("\n[ Info ] " + msg + "\n");
	}
	
	public static void welcomeMsg() {
		out("Bem-vindo!\n");
	}
	
	public static void quitMsg() {
		out("Programa finalizado!.\n");
	}
}
