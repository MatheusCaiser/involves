package br.com.teste.java.involves.utils;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.teste.java.involves.utils.PatternUtils;

public class PatternUtilsTest {

	private static PatternUtils pattern;
	
	@BeforeClass
	public static void init() {
		pattern = new PatternUtils();
	}
	
	@Test
	public void test() {
		Assert.assertTrue(pattern.check("Porto Velho", "porto velho"));
	}

}
