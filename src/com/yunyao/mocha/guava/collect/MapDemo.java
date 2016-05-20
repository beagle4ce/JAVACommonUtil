package com.yunyao.mocha.guava.collect;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;

/**
 * 
 * @author gf
 *
 */
public final class MapDemo {
	
	/**
	 * 类似电话簿, 一个key可对应多个value
	 */
	@Test
	public void arrayListMultimap() {
		ArrayListMultimap<String, String> m = ArrayListMultimap.create();
		m.put("zhangsan", "13111111111");
		m.put("zhangsan", "13222222222");
		m.put("lisi", "13333333333");
		// 得到 [13111111111, 13222222222]
		System.out.println(m.get("zhangsan"));
		// 得到 [13333333333]
		System.out.println(m.get("lisi"));
	}
	
	@Test
	public void hashMultimap() {
		HashMultimap<String, String> m = HashMultimap.create();
		m.put("zhangsan", "13111111111");
		m.put("zhangsan", "13111111111");
		m.put("zhangsan", "13222222222");
		m.put("lisi", "13333333333");
		// 得到 [13111111111, 13222222222], 与上面相比, 不同点, 这里得到的是Set
		System.out.println(m.get("zhangsan"));
		// 得到 [13333333333]
		System.out.println(m.get("lisi"));
	}
	
	/**
	 * value不可重复, 类似用户系统中 ID, USERNAME的关系, 两者都应该唯一
	 */
	@Test
	public void biMap() {
		BiMap<String, String> m = HashBiMap.create();
		m.put("zhangsan", "13111111111");
		// value不可重复, 下面一行会报错
		// m.put("lisi", "13111111111");
		// forcePut不会报错, 会覆盖之前的value
		m.forcePut("lisi", "13111111111");
		// key为zhangsan的值 已不在了
		System.out.println(m.get("zhangsan"));
		
		// 通过key获得value
		System.out.println(m.get("lisi"));
		// 通过value获得key, 之所以value不允许重复, 原因在此
		System.out.println(m.inverse().get("13111111111"));
	}
}
