package com.nico.trackit.model;

import java.util.Map;

/**
 * Created by Nico on 03.03.2015.
 */
public class GroupPurchaseItem {
    String label;
    int priceInCents;
    Map<String, Integer> distributionMap;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    public Map<String, Integer> getDistributionMap() {
        return distributionMap;
    }

    public void setDistributionMap(Map<String, Integer> distributionMap) {
        this.distributionMap = distributionMap;
    }
}
