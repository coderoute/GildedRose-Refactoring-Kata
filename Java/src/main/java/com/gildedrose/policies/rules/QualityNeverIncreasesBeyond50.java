package com.gildedrose.policies.rules;

import com.gildedrose.Item;

public class QualityNeverIncreasesBeyond50 implements UpdatePolicy {

    @Override
    public void apply(Item item) {
        if(item.quality > 50) {
            item.quality = 50;
        }
    }
}
