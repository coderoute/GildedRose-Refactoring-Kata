package com.gildedrose.expression;

import com.gildedrose.Item;

public class SellInLessThanDays extends Condition {

    private final int threshold;

    public SellInLessThanDays(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean eval(Item item) {
        return item.sellIn < threshold;
    }
}
