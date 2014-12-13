package com.nico.trackit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupPurchase extends GroupPurchaseComponent{
	
	private List<GroupPurchaseComponent> groupPurchaseComponents;
	
	public GroupPurchase(String name, Set<User> userList) {
		this.setName(name);
		this.groupPurchaseComponents = new ArrayList<>();
		this.setUsers(userList);
	}
	
	public void addGroupPurchaseComponent(GroupPurchaseComponent groupPurchaseComponent) {
		groupPurchaseComponents.add(groupPurchaseComponent);
	}

	@Override
	public int getPrice() {
		int price = groupPurchaseComponents.stream()
										   .map( p -> p.getPrice())
										   .reduce(0, (a, b) -> a + b);
		return price;
	}
	
	public PurchaseComponent getUserComponent(User user) {
		if (this.groupPurchaseComponents.isEmpty()) {
			return null;
		}
		
		Purchase purchase = new Purchase(getName());
		
		List<PurchaseComponent> purchaseComponents = groupPurchaseComponents.stream().map(g -> g.getUserComponent(user))
																	   				 .collect(Collectors.toList());
		purchase.setPurchaseComponents(purchaseComponents);
		return purchase;
		
	}

	public int getUserClaims(User creditor, User debtor) {
		return groupPurchaseComponents.stream()
									  .map(g -> g.getUserClaims(creditor, debtor))
									  .reduce(0, (a,b) -> a+b);
	}
}
