package com.yunyao.mocha.commons.lang3;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

/**
 * 
 * @author gf
 *
 */
public final class ObjectUtilsDemo {
	
	@Test
	public void defaultIfNull() {
		
		String s = ObjectUtils.defaultIfNull(null, "default.jpg");
		System.out.println(s);
	}
}
