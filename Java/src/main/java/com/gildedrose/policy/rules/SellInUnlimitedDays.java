package com.gildedrose.policy.rules;

import com.gildedrose.Item;

public class SellInUnlimitedDays implements UpdateRule {

    public void apply(Item item) {
        // do nothing, sellIn values does not need to change
    }
}
