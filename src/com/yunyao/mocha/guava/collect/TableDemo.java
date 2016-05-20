package com.yunyao.mocha.guava.collect;

import org.junit.Test;

import com.google.common.collect.HashBasedTable;

/**
 * 
 * @author gf
 *
 */
public final class TableDemo {
	
	/**
	 * 类似表格, 坐标系, 经纬网
	 */
	@Test
	public void hashBasedTable() {
		HashBasedTable<Integer, Integer, String> t = HashBasedTable.create();
		t.put(100, 10, "beijing");
		t.put(100, 20, "shanghai");
		t.put(10, 20, "chengdu");
		// 包含
		System.out.println(t.contains(100, 10));
		// 包含列
		System.out.println(t.containsColumn(20));
		// 通过列取值
		System.out.println(t.column(20));
		// 包含行
		System.out.println(t.containsRow(50));
		// 通过行取值
		System.out.println(t.row(100));
		// 包含值
		System.out.println(t.containsValue("chengdu"));
		// 得到 chengdu
		System.out.println(t.get(10, 20));
		
		System.out.println(t.remove(100, 10));
	}
}
