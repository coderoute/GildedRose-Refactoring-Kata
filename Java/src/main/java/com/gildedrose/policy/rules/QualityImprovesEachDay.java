package com.gildedrose.policy.rules;

import com.gildedrose.expression.Condition;
import com.gildedrose.expression.Quantity;

import static com.gildedrose.expression.Quantity.by;

public class QualityImprovesEachDay extends QualityDegradesEachDay {

    private QualityImprovesEachDay(Quantity quantity, Condition ... conditions) {
        super(by(-quantity.getValue()), conditions);
    }

    public static QualityImprovesEachDay qualityImprovesEachDay(Quantity quantity, Condition ... conditions) {
        return new QualityImprovesEachDay(quantity, conditions);
    }
}
