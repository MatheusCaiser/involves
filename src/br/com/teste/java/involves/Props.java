package br.com.teste.java.involves;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.com.teste.java.involves.console.Console;

/**
 * Classe de leitura do arquivo de configuração <b>config.properties</b>
 * @author Matheus Henrique Caiser
 *
 */
public class Props {

	private static Properties props;
	
	static {
		props = new Properties();
		
		try (InputStream in = new FileInputStream("config.properties")) {
			props.load(in);
		
		} catch (IOException e) {
			Console.error(e.getMessage());
		}
	}
	
	public static String getString(String property) {
		return props.getProperty(property);
	}
	
	public static int getInt(String property, int defaultValue) {
		String value = getString(property);
		
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
}
