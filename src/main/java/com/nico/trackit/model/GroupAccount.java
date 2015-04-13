package com.nico.trackit.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Nico on 17.03.2015.
 */
public class GroupAccount {
    String title;
    Set<User> users;
    List<GroupPurchase> purchases;

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

    public List<GroupPurchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<GroupPurchase> purchases) {
        this.purchases = purchases;
    }

    public void addPurchase(GroupPurchase purchase) {
        purchases.add(purchase);
    }

    public void removePurchase(GroupPurchase purchase) {
        purchases.remove(purchase);
    }
}
