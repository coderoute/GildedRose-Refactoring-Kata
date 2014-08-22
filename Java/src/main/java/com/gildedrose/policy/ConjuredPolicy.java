package com.gildedrose.policy;

import static com.gildedrose.expression.Condition.whenSellInGreaterThan;
import static com.gildedrose.expression.Condition.whenSellInLessThanOrEquals;
import static com.gildedrose.expression.Quantity.by;
import static com.gildedrose.policy.rules.QualityDegradesEachDay.qualityDegradesEachDay;

public class ConjuredPolicy extends GeneralItemPolicy {

    @Override
    public void qualityChangeWhenSellInLessThanOrEqualsZeroDays() {
        addPolicy(qualityDegradesEachDay(by(4), whenSellInLessThanOrEquals(0)));
    }

    @Override
    public void qualityChangeWhenSellInGreaterThanZeroDays() {
        addPolicy(qualityDegradesEachDay(by(2), whenSellInGreaterThan(0)));
    }
}
