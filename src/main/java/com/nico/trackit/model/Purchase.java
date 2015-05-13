package com.nico.trackit.model;

import java.sql.Date;
import java.util.List;

/**
 * Created by Nico on 17.03.2015.
 */
public class Purchase {
    String title;
    User purchaser;
    Date purchaseDate;
    List<GroupPurchaseItem> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(User purchaser) {
        this.purchaser = purchaser;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<GroupPurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<GroupPurchaseItem> items) {
        this.items = items;
    }
}
