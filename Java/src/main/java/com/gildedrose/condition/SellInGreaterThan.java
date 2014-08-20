package com.gildedrose.condition;

import com.gildedrose.Item;

public class SellInGreaterThan extends Condition {
    private final int threshold;

    public SellInGreaterThan(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean eval(Item item) {
        return item.sellIn > threshold;
    }
}
