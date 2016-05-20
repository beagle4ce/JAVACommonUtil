package com.yunyao.mocha.commons.io;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * 文件读取(小文件)
 * @author gf
 *
 */
public final class FileUtilsDemo {
	
	/**
	 * 注意文件过大不建议使用该方法
	 */
	@Test
	public void read() throws Exception {
		String path = "C:\\Users\\gf\\Desktop\\新建文本文档.txt";
		File file = new File(path);
		// 读取整个文本文件内容
		String centent = FileUtils.readFileToString(file, "UTF-8");
		System.out.println(centent);
		// 按行读取, 
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		for (String s : lines) {
			System.out.println("line ---> " + s);
		}
	}
	
	/**
	 * JAVA7 自带工具类可达到同样效果
	 */
	@Test
	public void readAllLines() throws Exception {
		// 告别拼接文件路径
		Path path = Paths.get("C:", "Users", "gf", "Desktop", "新建文本文档.txt");
		// 打印一下路径
		System.out.println(path.toString());
		List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));
		for (String s : lines) {
			System.out.println("line ---> " + s);
		}
	}
}
