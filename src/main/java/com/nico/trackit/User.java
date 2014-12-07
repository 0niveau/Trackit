package com.nico.trackit;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private List<PurchaseComponent> purchaseComponents;
	
	public User (String name) {
		this.name = name;
		purchaseComponents = new ArrayList<>();
	}
	
	public void add(PurchaseComponent purchaseComponent) {
		this.purchaseComponents.add(purchaseComponent);
	}
	
	public void addAll(List<PurchaseComponent> purchaseComponents) {
		this.purchaseComponents.addAll(purchaseComponents);
	}
	
	public int getSpendings() {
		return purchaseComponents.stream().map(p -> p.getPrice()).reduce(0, (a, b) -> a + b);
	}
	
	public void print() {
		System.out.println(name + ": " + getSpendings());
	}

}
