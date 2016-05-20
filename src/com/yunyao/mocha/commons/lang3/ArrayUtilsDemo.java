package com.yunyao.mocha.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * 
 * @author gf
 *
 */
public final class ArrayUtilsDemo {
	
	@Test
	public void isEmpty() {
		String[] ss = {"1", "2", "3"};
		System.out.println(ArrayUtils.isEmpty(ss));
		System.out.println(ArrayUtils.isNotEmpty(ss));
	}
	
	@Test
	public void toPrimitive() {
		Integer[] is = {1, 2, 3, 4};
		
		int[] pis = ArrayUtils.toPrimitive(is);
		// 转基本数据类型
		System.out.println(ArrayUtils.toString(pis));
		
		Integer[] is2 = ArrayUtils.toObject(pis);
		// 转包装类类型
		System.out.println(ArrayUtils.toString(is2));
	}
	
	@Test
	public void contains() {
		String[] ss = {"1", "2", "3"};
		System.out.println(ArrayUtils.contains(ss, "2"));
	}
	
	@Test
	public void add() {
		String[] ss = {"1", "2", "3"};
		ss = ArrayUtils.add(ss, "4");
		System.out.println(ArrayUtils.toString(ss));
	}
	
	/**
	 * 反转
	 */
	@Test
	public void reverse() {
		String[] ss = {"1", "2", "3"};
		ArrayUtils.reverse(ss);
		System.out.println(ArrayUtils.toString(ss));
	}
}
