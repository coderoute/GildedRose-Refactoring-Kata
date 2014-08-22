package com.gildedrose.policy.rules;

import com.gildedrose.Item;

public class QualityIsNeverNegative implements UpdateRule {
    @Override
    public void apply(Item item) {
        if(item.quality < 0) {
            item.quality = 0;
        }
    }
}
