package com.gildedrose.policy.rules;

import com.gildedrose.Item;

public class QualityNeverIncreasesBeyond50 implements UpdateRule {

    @Override
    public void apply(Item item) {
        if(item.quality > 50) {
            item.quality = 50;
        }
    }
}
