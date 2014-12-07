package com.nico.trackit;

import java.util.ArrayList;
import java.util.List;

public class Purchase extends PurchaseComponent {
	
	private List<PurchaseComponent> purchaseComponents;
	
	public Purchase(String name) {
		this.setName(name);
		this.purchaseComponents = new ArrayList<>();
	}
	
	public void setPurchaseComponents (List<PurchaseComponent> components) {
		this.purchaseComponents = components;
	}
	
	public void add(PurchaseComponent purchaseComponent) {
		purchaseComponents.add(purchaseComponent);
	}
	
	public void remove(PurchaseComponent purchaseComponent) {
		this.purchaseComponents.remove(purchaseComponent);
	}
	
	public int getPrice() {
		int price = purchaseComponents.stream()
				.map( p -> p.getPrice())
				.reduce(0, (a, b) -> a + b);
		return price;
	}
	
	public void print() {
		System.out.println(this.getName());
		System.out.println("--------------------------------");
		purchaseComponents.stream().forEach(p -> p.print());
		System.out.println("--------------------------------");
		System.out.println("Total of " + this.getName() + ":\t" + this.getPrice());
	}
}
