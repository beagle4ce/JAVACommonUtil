package com.yunyao.mocha.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * <pre>
 * 非常常用的工具类
 * org.apache.commons.lang3.StringUtils相比String自身方法, 做了优化与扩展, 加入了null保护
 * </pre>
 * @author gf
 *
 */
@SuppressWarnings("unchecked")
public final class StringUtilsDemo {
	
	/**
	 * <p>Checks if a CharSequence is whitespace, empty ("") or null.</p>
	 *
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 */
	@Test
	public void isBlank() {
		String s1 = null;
		String s2 = "";
		String s3 = " ";
		String s4 = "Test";
		
		System.out.println(StringUtils.isBlank(s1));
		System.out.println(StringUtils.isBlank(s2));
		System.out.println(StringUtils.isBlank(s3));
		System.out.println(StringUtils.isBlank(s4));
	}
	
	/**
	 * 与 StringUtils.isBlank(CharSequence) 相反
	 */
	@Test
	public void isNotBlank() {
		String s1 = null;
		String s2 = "";
		String s3 = " ";
		String s4 = "Test";
		
		System.out.println(StringUtils.isNotBlank(s1));
		System.out.println(StringUtils.isNotBlank(s2));
		System.out.println(StringUtils.isNotBlank(s3));
		System.out.println(StringUtils.isNotBlank(s4));
	}
	
	@Test
	public void isEmpty() {
		String s1 = null;
		String s2 = "";
		String s3 = " ";
		String s4 = "Test";
		
		System.out.println(StringUtils.isEmpty(s1));
		System.out.println(StringUtils.isEmpty(s2));
		System.out.println(StringUtils.isEmpty(s3));
		System.out.println(StringUtils.isEmpty(s4));
	}
	
	/**
	 * 与 StringUtils.isEmpty(CharSequence) 相反
	 */
	@Test
	public void isNotEmpty() {
		String s1 = null;
		String s2 = "";
		String s3 = " ";
		String s4 = "Test";
		
		System.out.println(StringUtils.isNotEmpty(s1));
		System.out.println(StringUtils.isNotEmpty(s2));
		System.out.println(StringUtils.isNotEmpty(s3));
		System.out.println(StringUtils.isNotEmpty(s4));
	}
	
	/**
	 * String类split方法是基于正则表达式的实现, 但是我们在使用过程中, 大部分情况并不需要. StringUtils则是进行字符匹配, 所以在频繁的字符串分割的情况下, StringUtils效率要优一些
	 */
	@Test
	public void split() {
		ToStringBuilder.reflectionToString(this);
		String s1 = "A_B_C_DC";
		
		// 单个字符的切割
		System.out.println(Arrays.deepToString(StringUtils.split(s1, '_')));
		// 和上面的效果一样
		System.out.println(Arrays.deepToString(StringUtils.split(s1, "_")));
		
		// 这个方法可能会让你失望, 并不会出现[A_B_, D], 该方法的逻辑时, 使用'C' OR '_' 进行分割
		System.out.println(Arrays.deepToString(StringUtils.split(s1, "C_")));
		// 使用这个方法就OK
		System.out.println(Arrays.deepToString(StringUtils.splitByWholeSeparator(s1, "C_")));
		
		// 对工具类提供一些扩展, 我们可以获得更方便的工具方法, 使代码更简洁
		String ints = "5641,46416,4864";
		System.out.println(splitToInt(ints, ","));
		
		String longs = "1641616161536156,145645641646546486,76564164564656566";
		System.out.println(splitToLong(longs, ","));
	}
	public static void main(String[] args) {

		String longs = "1641616161536156,145645641646546486,76564164564656566";
		System.out.println(splitToLong(longs, ","));
	}
	public static List<Integer> splitToInt(String source, String separator) {
		return splitToNumber(source, separator);
	}
	
	public static List<Long> splitToLong(String source, String separator) {
		return splitToNumber(source, separator);
	}
	
	private static <T extends Number> List<T> splitToNumber(String source, String separator) {
		if (StringUtils.isBlank(source)) {
			return Collections.emptyList();
		}
		String[] parts = StringUtils.splitByWholeSeparator(source, separator);
		List<T> result = new ArrayList<T>(parts.length);
		for (String part : parts) {
			try {
				result.add((T)NumberUtils.createNumber(part));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return  result;
	}
	
	@Test
	public void trim() {
		String s1 = " A ";
		// 和String效果一样
		System.out.println(StringUtils.trim(s1));
		
		String s2 = null;
		
		System.out.println(StringUtils.trim(s2));
		// 如果是null, 返回空白字符串, 参数验证的时候较有用
		System.out.println(StringUtils.trimToEmpty(s2));
	}
	
	@Test
	public void reverse() {
		String s1 = "ABCD";
		// 反转字符串
		System.out.println(StringUtils.reverse(s1));
		// 另附原生实现
		System.out.println(new StringBuilder(s1).reverse());
	}
	
	/**
	 * 较有用
	 */
	@Test
	public void substring() {
		String s1 = "AAXXXXXXXXBB";
		
		System.out.println(StringUtils.substringBetween(s1, "A", "B"));
		
		
		System.out.println(StringUtils.substringAfter(s1, "A"));
		System.out.println(StringUtils.substringAfterLast(s1, "A"));
		
		System.out.println(StringUtils.substringBefore(s1, "B"));
		System.out.println(StringUtils.substringBeforeLast(s1, "B"));
		
		String s2 = "AXBAXB";
		// 返回字符串数组
		System.out.println(Arrays.deepToString(StringUtils.substringsBetween(s2, "A", "B")));
	}
	
	/**
	 * 首字母大小写
	 */
	@Test
	public void capitalize() {
		String s1 = "zhang";
		
		System.out.println(StringUtils.capitalize(s1));
		
		String s2 = "Zhang";
		System.out.println(StringUtils.uncapitalize(s2));
	}
	
	/**
	 * 是否是数字
	 */
	@Test
	public void isNumeric() {
		String s1 = "100";
		// 仅整型数字
		System.out.println(StringUtils.isNumeric(s1));
		String s2 = "100.1";
		// org.apache.commons.lang3.StringUtils.isNumeric(CharSequence) 不能判断出浮点型
		System.out.println(StringUtils.isNumeric(s2));
		
		// 仅整型数字
		System.out.println(NumberUtils.isDigits(s2));
		// 判断出浮点型, 需要用到 org.apache.commons.lang3.math.NumberUtils.isNumber(String)
		System.out.println(NumberUtils.isNumber(s2));
	}
	
	@Test
	public void isAlpha() {
		String s1 = "qswqsws";
		// 是否全有英文字符组成
		System.out.println(StringUtils.isAlpha(s1));
		
		String s2 = "qswqsw121s";
		// 是否全有英文或者数字组成
		System.out.println(StringUtils.isAlphanumeric(s2));
	}
	
	/**
	 * 不区分大小写相关
	 */
	@Test
	public void ignoreCase() {
		String s1 = "adxwedwe";
		
		System.out.println(StringUtils.startsWithIgnoreCase(s1, "A"));
		
		System.out.println(StringUtils.endsWithIgnoreCase(s1, "E"));
		
		System.out.println(StringUtils.indexOfIgnoreCase(s1, "D"));
	}
}
