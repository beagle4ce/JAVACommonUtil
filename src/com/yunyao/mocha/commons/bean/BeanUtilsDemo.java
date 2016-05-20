package com.yunyao.mocha.commons.bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.yunyao.mocha.model.User;

/**
 * <pre>
 * 反射相关, 很方便的获取对象属性
 * </pre>
 * @author gf
 *
 */
public final class BeanUtilsDemo {
	
	/**
	 * Get操作
	 */
	@Test
	public void getProperty() throws Exception {
		User jim = new User(1, "jim");
		
		jim.setMother(new User(2, "lucy"));
		jim.setFriends(new User[] {new User(3, "lee")});
		jim.setNicknames(new String[] {"kim"});
		jim.setClassmates(Lists.newArrayList(new User(4, "kaka")));
		
		Object user = jim;
		
		// 获取普通属性
		String name = BeanUtils.getProperty(user, "name");
		System.out.println(name);
		
		// 获取数组属性
		String[] nicknames = BeanUtils.getArrayProperty(user, "nicknames");
		System.out.println(Arrays.deepToString(nicknames));
		
		String[] friends = BeanUtils.getArrayProperty(user, "friends");
		System.out.println(Arrays.deepToString(friends));
		
		// 获取嵌套的属性
		String mname = BeanUtils.getNestedProperty(user, "mother.name");
		System.out.println(mname);
		
		
		// 获取数组中对象
		String lname = BeanUtils.getNestedProperty(user, "friends.[0].name");
		System.out.println(lname);
		
		// List相同
		String cname = BeanUtils.getNestedProperty(user, "classmates.[0].name");
		System.out.println(cname);
	}
	
	/**
	 * Set操作
	 */
	@Test
	public void setProperty() throws Exception {
		User jim = new User(1, "jim");
		
		User lucy = new User(2, "lucy");
		
		jim.setFriends(new User[] {new User(3, "lee")});
		jim.setNicknames(new String[] {"kim"});
		jim.setClassmates(Lists.newArrayList(new User(4, "kaka")));
		jim.setMother(lucy);
		
		Object user = jim;
		
		BeanUtils.setProperty(user, "name", "kim");
		System.out.println(jim.getName());
		
		BeanUtils.setProperty(user, "classmates.[0].name", "kakaka");
		System.out.println(jim.getClassmates().get(0).getName());
	}
	
	@Test
	public void describe() throws Exception {
		User jim = new User(1, "jim");
		// 得到 {id=1, nicknames=null, friends=null, mother=null, name=jim, class=class com.yunyao.mocha.commons.bean.BeanUtilsDemo$User, classmates=null}
		// 对象转map, 注意会加入一个class的值
		System.out.println(BeanUtils.describe(jim));
	}
	
	@Test
	public void populate() throws Exception {
		User jim = new User();
		Map<String, Object> kvs = new HashMap<String, Object>();
		kvs.put("id", 1);
		kvs.put("name", "jim");
		BeanUtils.populate(jim, kvs);
		// 得到[id=1,name=jim,nicknames=<null>,mother=<null>,friends=<null>,classmates=<null>]
		// Map的值注入到对象
		System.out.println(jim);
	}
}
