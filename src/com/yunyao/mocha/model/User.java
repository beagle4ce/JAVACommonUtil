package com.yunyao.mocha.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class User implements Serializable {
	
	private static final long serialVersionUID = 2591477231513713616L;
	
	int id;
	
	String name;
	
	String[] nicknames;
	
	User mother;
	
	User[] friends;
	
	List<User> classmates;
	
	public User() {
		super();
	}

	public User(int id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getNicknames() {
		return nicknames;
	}

	public void setNicknames(String[] nicknames) {
		this.nicknames = nicknames;
	}

	public User getMother() {
		return mother;
	}

	public void setMother(User mother) {
		this.mother = mother;
	}

	public User[] getFriends() {
		return friends;
	}

	public void setFriends(User[] friends) {
		this.friends = friends;
	}

	public List<User> getClassmates() {
		return classmates;
	}

	public void setClassmates(List<User> classmates) {
		this.classmates = classmates;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
