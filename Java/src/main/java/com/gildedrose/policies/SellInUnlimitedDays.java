package com.gildedrose.policies;

import com.gildedrose.Item;

public class SellInUnlimitedDays implements UpdatePolicy {

    public void apply(Item item) {
        // do nothing, sellIn values does not need to change
    }
}
