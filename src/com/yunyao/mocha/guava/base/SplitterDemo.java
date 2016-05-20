package com.yunyao.mocha.guava.base;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * 
 * @author gf
 *
 */
public final class SplitterDemo {
	
	/**
	 * 这些方法StringUtils都有, String的工具类, 还是StringUtils比较强
	 */
	@Test
	public void split() {
		String s = "A_B_C_B";
		// 分割
		List<String> list = Splitter.on("B_").splitToList(s);
		System.out.println(list);
		
		// 拼装
		String sCopy = Joiner.on("_").join(list);
		System.out.println(sCopy);
	}
}
