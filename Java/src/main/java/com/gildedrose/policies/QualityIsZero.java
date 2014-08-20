package com.gildedrose.policies;

import com.gildedrose.Item;
import com.gildedrose.condition.Condition;

public class QualityIsZero implements UpdatePolicy {

    private Condition conditon;

    private QualityIsZero(Condition condition) {
        this.conditon = condition;
    }

    public static QualityIsZero qualityIsZero(Condition condition) {
        return new QualityIsZero(condition);
    }

    @Override
    public void apply(Item item) {
        if(conditon.eval(item)) {
            item.quality = 0;
        }
    }
}
