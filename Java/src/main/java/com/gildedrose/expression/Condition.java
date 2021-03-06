package com.gildedrose.expression;

import com.gildedrose.Item;

public abstract class Condition {

    public abstract boolean eval(Item item);

    public static SellInLessThanDays sellInLessThan(int days) {
        return new SellInLessThanDays(days);
    }

    public static SellInLessThanDays whenSellInLessThanOrEquals(int days) {
        return new SellInLessThanDays(days + 1);
    }

    public static SellInGreaterThan whenSellInGreaterThan(int days) {
        return new SellInGreaterThan(days);
    }

    public static SellInGreaterThan sellInGreaterThanOrEquals(int days) {
        return new SellInGreaterThan(days - 1);
    }
}
