package com.nico.trackit;

import java.util.Map;
import java.util.Set;

public abstract class GroupPurchaseComponent {
	private String name;
	private Set<User> userList;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<User> getUsers() {
		return userList;
	}
	
	public void setUsers(Set<User> userList) {
		this.userList = userList;
	}
	
	public void add(User user) {
		userList.add(user);
	}
	
	public void remove(User user) {
		userList.remove(user);
	}
	
	public abstract int getPrice();

	public abstract PurchaseComponent getUserComponent(User user);

	public abstract int getUserClaims(User creditor, User debtor);

}
