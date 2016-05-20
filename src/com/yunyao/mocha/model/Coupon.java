package com.yunyao.mocha.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class Coupon implements Serializable {
	
	private static final long serialVersionUID = 6487048274608529131L;
	
	private int value;
	
	private boolean isUsed;
	
	private Date expiredDate;
	
	public Coupon() {
		super();
	}
	
	public Coupon(int value, boolean isUsed, Date expiredDate) {
		this();
		this.value = value;
		this.isUsed = isUsed;
		this.expiredDate = expiredDate;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	@Override
	public String toString() {
		return "Coupon [value=" + value + ", isUsed=" + isUsed + ", expiredDate=" + DateFormatUtils.format(expiredDate, "yyyy-MM-dd HH:mm:ss") + "]";
	}
}
