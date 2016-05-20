package com.yunyao.mocha.commons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * 
 * @author gf
 *
 */
public final class IOUtilsDemo {
	
	@Test
	public void read() throws Exception {
		String path = "C:\\Users\\gf\\Desktop\\新建文本文档.txt";
		File file = new File(path);
		
		FileInputStream fis1 = new FileInputStream(file);	
		String content = IOUtils.toString(fis1, "UTF-8");
		System.out.println(content);
		IOUtils.closeQuietly(fis1);
		
		FileInputStream fis2 = new FileInputStream(file);
		List<String> lines = IOUtils.readLines(fis2, "UTF-8");
		for (String s : lines) {
			System.out.println("line ---> " + s);
		}
		IOUtils.closeQuietly(fis2);
	}
	
	@Test
	public void copy() throws Exception {
		String path1 = "C:\\Users\\gf\\Desktop\\新建文本文档.txt";
		File file1 = new File(path1);
		
		FileInputStream fis = new FileInputStream(file1);
		
		String path2 = "C:\\Users\\gf\\Desktop\\新建文本文档2.txt";
		File file2 = new File(path2);
		FileOutputStream fos = new FileOutputStream(file2);
		
		IOUtils.copy(fis, fos);
		
		IOUtils.closeQuietly(fis);
		IOUtils.closeQuietly(fos);
	}
}
