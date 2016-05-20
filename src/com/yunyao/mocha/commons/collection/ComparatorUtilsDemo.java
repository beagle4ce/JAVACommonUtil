package com.yunyao.mocha.commons.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.joda.time.DateTime;
import org.junit.Test;

import com.yunyao.mocha.model.Coupon;

/**
 * 
 * @author gf
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public final class ComparatorUtilsDemo {
	
	/**
	 * beanList排序, 以一个优惠券列表作为例子
	 */
	@Test
	public void beanComparator() {
		
		List<Coupon> coupons = new ArrayList<Coupon>();
		
		coupons.add(new Coupon(100, false, DateTime.parse("2016-01-01").toDate()));
		coupons.add(new Coupon(100, false, DateTime.parse("2016-02-01").toDate()));
		coupons.add(new Coupon(100, true, DateTime.parse("2016-02-01").toDate()));
		coupons.add(new Coupon(50, false, DateTime.parse("2016-01-01").toDate()));
		coupons.add(new Coupon(50, false, DateTime.parse("2016-02-01").toDate()));
		coupons.add(new Coupon(50, true, DateTime.parse("2016-02-01").toDate()));
		// 多维度排序
		List<Comparator<Coupon>> comparators = new ArrayList<Comparator<Coupon>>();
		// 倒序
		comparators.add(ComparatorUtils.reversedComparator(new BeanComparator("value")));
		comparators.add(new BeanComparator("isUsed"));
		comparators.add(new BeanComparator("expiredDate"));
		ComparatorChain multiSort = new ComparatorChain(comparators);
		Collections.sort(coupons, multiSort);
		for (Coupon c : coupons) {
			System.out.println(c);
		}
	}
}
