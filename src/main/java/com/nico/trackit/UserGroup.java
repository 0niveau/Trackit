package com.nico.trackit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserGroup {
	private String name;
	Set<User> users;
	List<GroupPurchaseComponent> groupBalance;
	
	public UserGroup(String name) {
		this.name = name;
		this.users = new HashSet<>();
		this.groupBalance = new ArrayList<>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void remove(User user) {
		users.remove(user);
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	public void addGroupPurchaseComponent(GroupPurchaseComponent groupPurchaseComponent) {
		groupBalance.add(groupPurchaseComponent);
	}
	
	public void doAccounting() {
		for (User user : users) {
			List<PurchaseComponent> purchaseComponents = groupBalance.stream().map(p -> p.getUserComponent(user)).collect(Collectors.toList()); 
			user.addAll(purchaseComponents);
		}
	}

	public void doSomething() {

	}
}
