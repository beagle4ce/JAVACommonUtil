package com.yunyao.mocha.commons.lang3;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

/**
 * 
 * @author gf
 *
 */
public final class DateFormatUtilsDemo {
	
	@Test
	public void format() {
		
		System.out.println(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
		
		System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}
}
