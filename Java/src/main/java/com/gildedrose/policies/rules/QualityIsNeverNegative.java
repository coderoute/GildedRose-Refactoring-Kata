package com.gildedrose.policies.rules;

import com.gildedrose.Item;

public class QualityIsNeverNegative implements UpdatePolicy {
    @Override
    public void apply(Item item) {
        if(item.quality < 0) {
            item.quality = 0;
        }
    }
}
