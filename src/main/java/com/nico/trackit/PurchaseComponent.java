package com.nico.trackit;

public abstract class PurchaseComponent {

	private String name;
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public abstract int getPrice();
	
	public abstract void print();
	
}
