package com.yunyao.mocha.commons.collection;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.yunyao.mocha.model.User;

/**
 * 
 * @author gf
 * JAVA自带Collections工具类
 * 
 */
public final class CollectionsDemo {
	
	@Test
	public void emptyList() {
		System.out.println(returnEmptyList(null));
	}
	
	/**
	 * 模拟使用场景 : 通过id集合批量查询出实体对象集合, 当id集合为空的时候, 直接返回一个空对象集合 节省数据库IO
	 * 技巧 : 若参数idList为空, 则返回一个Collections.emptyList(), 可避免new ArrayList()开辟内存
	 * 注意 : Collections.emptyList()为一个immutable集合, 并不能向里面放入对象, 但是实际使用场景下, 我们很少需要向其中添加对象; 类似还有Collections.emptyMap() Collections.emptySet()
	 */
	private List<User> returnEmptyList(List<Integer> idList) {
		if (CollectionUtils.isEmpty(idList)) {
			return Collections.emptyList();
		}
		return Lists.newArrayList(new User(), new User());
	}
}
