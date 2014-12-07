package com.nico.trackit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PurchaseDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User adri = new User("adri");
		User stefan = new User("stefan");
		User nico = new User("nico");
		
		UserGroup wg = new UserGroup("WG");
		wg.addUser(adri);
		wg.addUser(stefan);
		wg.addUser(nico);
		
		System.out.println("Adri Stefan and Nico have founded a new group!");		
		
		Map<User, Integer> distributionMapApfel = new HashMap<>();
		distributionMapApfel.put(adri, 1);
		distributionMapApfel.put(nico, 1);
		distributionMapApfel.put(stefan, 2);
		wg.addGroupPurchaseComponent(new GroupPurchaseItem("Apfel", 1990, distributionMapApfel));
		
		Map<User, Integer> distributionMapMicro = new HashMap<>();
		distributionMapMicro.put(nico, 0);
		distributionMapMicro.put(adri, 1);
		distributionMapMicro.put(stefan, 2);
		
		GroupPurchase groupPurchase = new GroupPurchase("things", wg.getUsers());
		groupPurchase.addGroupPurchaseComponent(new GroupPurchaseItem("Micro", 60000, distributionMapMicro));
		wg.addGroupPurchaseComponent(groupPurchase);
		
		System.out.println("---- Spendings before accounting");
		
		adri.print();
		nico.print();
		stefan.print();
		
		System.out.println("---- Doing accounting");
		
		wg.doAccounting();
		
		System.out.println("---- Spendings after accounting");
		
		adri.print();
		nico.print();
		stefan.print();
	}
}
