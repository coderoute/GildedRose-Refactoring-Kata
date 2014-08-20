package com.gildedrose.policies;

import com.gildedrose.Item;

public class SellInGivenDays  implements UpdatePolicy {

    /**
     * Decrements the sellIn value by 1 each time this method is called
     * @param item
     */
    public void apply(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
