package com.yunyao.mocha.commons.lang3;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * 
 * @author gf
 *
 */
public final class RandomStringUtilsDemo {
	
	/**
	 * 使用场景 短信验证码
	 */
	@Test
	public void randomString() {
		// 数字短信验证码
		System.out.println(RandomStringUtils.randomNumeric(6));
		// 字母
		System.out.println(RandomStringUtils.randomAlphabetic(6));
		// 数字 + 字母
		System.out.println(RandomStringUtils.randomAlphanumeric(6));
	}
}
