package br.com.teste.java.involves;

import br.com.teste.java.involves.principal.Principal;

public class Main {
	public static void main(String[] args) {
		String csvFile = Props.getString("csvFile");
		new Principal(csvFile).initialize();
	}
}
