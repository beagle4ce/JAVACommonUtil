package com.yunyao.mocha.commons.codec;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * 
 * @author gf
 *
 */
public final class DigestUtilsDemo {
	
	/**
	 * MD5加密
	 */
	@Test
	public void md5() {
		System.out.println(DigestUtils.md5Hex("123456"));
	}
}
