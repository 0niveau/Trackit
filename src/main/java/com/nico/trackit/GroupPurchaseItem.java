package com.nico.trackit;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupPurchaseItem extends GroupPurchaseComponent {
	
	private int price;
	private Map<User, Integer> distributionMap;
	private User purchaser;
	
	public GroupPurchaseItem (String name, int price, User purchaser, Map<User, Integer> distributionMap) {
		this.setName(name);
		this.price = price;
		this.purchaser = purchaser;
		this.distributionMap = distributionMap;
		setUsers(distributionMap.keySet());
	}

	public void setPrice(int price) {
		this.price = price;				
	}
	
	@Override
	public int getPrice() {	
		return price;
	}

	private Map<User, Integer> getPriceDistribution() {
		int distributionUnits = distributionMap.values().stream().reduce(0, (a, b) -> a + b);
		int distributionPrice = this.getPrice() / distributionUnits;
		Map<User, Integer> priceDistribution =	new HashMap<>();
		distributionMap.entrySet().stream()
								  .forEach(p -> {
									  int price = p.getValue().intValue()*distributionPrice;
									  priceDistribution.put(p.getKey(),Integer.valueOf(price)); 
								  });
		return priceDistribution;								  				
	}
	
	public PurchaseComponent getUserComponent(User user) {
		int itemPrice = getPriceDistribution().get(user);
		PurchaseItem purchaseItem = new PurchaseItem(getName(), itemPrice);
		return purchaseItem;
	}

	public int getUserClaims(User creditor, User debtor) {
		if (this.purchaser.equals(creditor)) {
			return getPriceDistribution().get(debtor);
		} else {
			return 0;
		}
	}
}
