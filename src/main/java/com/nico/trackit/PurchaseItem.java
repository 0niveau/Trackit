package com.nico.trackit;

import java.util.ArrayList;
import java.util.List;

public class PurchaseItem extends PurchaseComponent {
	
	private int price;
	
	public PurchaseItem (String name, int price) {
		this.setName(name);
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

	public void print() {
		System.out.println(this.getName() + "\t\t\t" + this.getPrice());
	}
	
	public static List<PurchaseItem> split(PurchaseItem purchaseItem, int i) {
		List<PurchaseItem> splitItems = new ArrayList<>();
		int splitPrice = purchaseItem.getPrice() / i;
		for (int z = 0; z < i; z++) {
			splitItems.add(new PurchaseItem(purchaseItem.getName(), splitPrice));
		}
		return splitItems;
	}
	
	public static PurchaseItem mergeItems(List<PurchaseItem> purchaseItems) {
		PurchaseItem head = purchaseItems.get(0);
		boolean allEqual = purchaseItems.stream().allMatch(a -> a.equals(head));
		if (!allEqual) {
			return null;
		}
		
		int mergePrice = head.getPrice() * purchaseItems.size();
		return new PurchaseItem(head.getName(), mergePrice);
	}

	public boolean equals(PurchaseItem purchaseItem) {
		return (this.getName() == (purchaseItem).getName()) && (this.getPrice() == purchaseItem.getPrice());
	}
}
