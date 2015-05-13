package com.nico.trackit.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Nico on 17.03.2015.
 */
public class GroupAccount {
    int id;
    String title;
    Set<User> users;
    List<Purchase> purchases;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser (User user) {
        if (users == null) {
            users = new HashSet<>();
        }
        users.add(user);
    }

    public void removeUser(User user) {
        if(users != null) {
            users.remove(user);
        }
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public void removePurchase(Purchase purchase) {
        purchases.remove(purchase);
    }
}
