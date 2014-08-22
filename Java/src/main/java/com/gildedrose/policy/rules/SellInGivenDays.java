package com.gildedrose.policy.rules;

import com.gildedrose.Item;

public class SellInGivenDays  implements UpdateRule {

    /**
     * Decrements the sellIn value by 1 each time this method is called
     * @param item
     */
    public void apply(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
