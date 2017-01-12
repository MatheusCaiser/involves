package br.com.teste.java.involves.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtils {
	Pattern p;
	Matcher m;
	
	public boolean check(String expected, String value) {
		p = Pattern.compile(value, Pattern.CASE_INSENSITIVE);
		m = p.matcher(expected);
		return m.matches();
	}
}
