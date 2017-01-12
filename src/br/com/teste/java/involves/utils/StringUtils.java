package br.com.teste.java.involves.utils;

public class StringUtils {
	public static boolean isNull(String arg) {
		if (arg == null)
			return true;
		else
			return false;
	}

	public static boolean isBlank(String arg) {
		if (arg == "")
			return true;
		else
			return false;
	}
	
	public static boolean isNullOrBlank(String arg) {
		return isNull(arg) || isBlank(arg);
	}
	
	public static boolean isEmpty(String arg) {
		return arg.isEmpty();
	}
	
	public static String[] stringToArray(String input, String splitBy) {
		return input.split(splitBy);
	}
	
	public static String StringArrayToString(String[] sa) {
		String c = "";
		for (String s : sa) {
			c += s + " | ";
		}
		return c.trim();
	}
}
