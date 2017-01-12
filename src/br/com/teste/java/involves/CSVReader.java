package br.com.teste.java.involves;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import br.com.teste.java.involves.console.Console;
import br.com.teste.java.involves.utils.StringUtils;


/**
 * Classe responsavél pela leitura do arquivo CSV
 * 
 * @author Matheus Henrique Caiser
 *
 */
public class CSVReader {
	private String csvFile;
	private String splitBy = ",";

	public CSVReader(String file, String splitBy) {
		this.csvFile = file;
		this.splitBy = splitBy;
	}

	public boolean hasProperty(String property) {
		return (this.getHeaderPosition(property) > -1);
	}

	public int getHeaderPosition(String header) {
		return Arrays.asList(this.getHeader()).indexOf(header);
	}

	public ArrayList<String> getLinesWith(String property, String value) {
		ArrayList<String> lines = new ArrayList<String>();

		if (this.hasProperty(property)) {
			int propertyPosition = this.getHeaderPosition(property);
			String line;
			int currentLineIndex = 0;

			try (BufferedReader br = new BufferedReader(createInputStreamReader())) {
				while ((line = br.readLine()) != null) {
					if (currentLineIndex > 0) {
						String[] currenteTuple = line.split(splitBy);
						if (currenteTuple[propertyPosition].equalsIgnoreCase(value) && (!currenteTuple[propertyPosition].isEmpty())) {
							lines.add(line.replaceAll(",", " | "));
						}
					}
					currentLineIndex++;
				}
			} catch (FileNotFoundException e) {
				Console.error(Props.getString("errorFileNotFound"));
				return null;
			} catch (IOException e) {
				Console.error(e.getMessage());
				return null;
			}
		}
		return lines;
	}

	public ArrayList<String> readColumn(String columnName, boolean distinct) {
		ArrayList<String> column = new ArrayList<String>();

		if (this.hasProperty(columnName)) {
			int propertyPosition = this.getHeaderPosition(columnName);
			String line;
			int currentLineIndex = 0;
			try (BufferedReader br = new BufferedReader(createInputStreamReader())) {

				if (distinct) {
					String[] currentTuple;
					while ((line = br.readLine()) != null) {
						currentTuple = line.split(splitBy);
						if (currentLineIndex > 0) {
							if (!column.contains(currentTuple[propertyPosition]) && !currentTuple[propertyPosition].isEmpty()) {
								column.add(currentTuple[propertyPosition]);
							}
						}
						currentLineIndex++;
					}
				} else {
					if (currentLineIndex > 0) {
						while ((line = br.readLine()) != null) {
							if (currentLineIndex > 0) {
								String[] tp = line.split(splitBy);
								column.add(tp[propertyPosition]);
							}
							currentLineIndex++;
						}
					}

				}
			} catch (FileNotFoundException e) {
				Console.error(Props.getString("errorFileNotFound"));
				return null;
			} catch (IOException e) {
				e.getMessage();
				return null;
			}
		}
		return column;
	}

	private FileInputStream createFileStreamReader() throws FileNotFoundException {
		return new FileInputStream(csvFile);
	}
	
	private InputStreamReader createInputStreamReader() throws UnsupportedEncodingException, FileNotFoundException {
		return new InputStreamReader(createFileStreamReader(), "UTF-8");
	}

	public String[] getHeader() {
		try (BufferedReader br = new BufferedReader(createInputStreamReader())) {
			return StringUtils.stringToArray(br.readLine(), splitBy);
		} catch (FileNotFoundException e) {
			Console.error(Props.getString("errorFileNotFound"));
			return null;
		} catch (IOException e) {
			Console.error(e.getMessage());
			return null;
		}
	}

	public int countAll() {
		int count = 0;
		try (BufferedReader br = new BufferedReader(createInputStreamReader())) {
			while (br.readLine() != null) {
				count++;
			}
		} catch (FileNotFoundException e) {
			Console.error(Props.getString("errorFileNotFound"));
			return 1;
		} catch (IOException e) {
			Console.error(e.getMessage());
			return 1;
		}
		return count;
	}

	public String headersToString() {
		return ("\n[ Info ] Propriedades disponíveis:\n" + StringUtils.StringArrayToString(this.getHeader()) + "\n");
	}
}
