package com.nico.trackit.model;

import java.util.List;

/**
 * Created by Nico on 17.03.2015.
 */
public class Purchase {
    String title;
    User purchaser;
    List<GroupPurchaseItem> items;
}
