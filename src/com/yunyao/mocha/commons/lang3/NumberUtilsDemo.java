package com.yunyao.mocha.commons.lang3;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * 
 * @author gf
 *
 */
public final class NumberUtilsDemo {
	
	@Test
	public void isNumber() {
		String s1 = "100";
		// 仅整型
		System.out.println(NumberUtils.isDigits(s1));
		// 包括浮点型
		System.out.println(NumberUtils.isNumber(s1));
		
		String s2 = "100.1";
		System.out.println(NumberUtils.isDigits(s2));
		System.out.println(NumberUtils.isNumber(s2));
	}
	
	@Test
	public void toInt() {
		String s1 = "221";
		
		System.out.println(NumberUtils.toInt(s1));
		
		String s2 = "wejd";
		// 异常时, 返回指定默认值
		System.out.println(NumberUtils.toInt(s2, 1));
		
		// NumberUtils.toFloat(String)等同理
	}
	
	@Test
	public void max() {
		int[] is = {1, 2, 3, 4, 5};
		System.out.println(NumberUtils.max(is));
	}
}
