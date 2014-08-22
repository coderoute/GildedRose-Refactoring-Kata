package com.gildedrose.policy;

import static com.gildedrose.expression.Condition.whenSellInGreaterThan;
import static com.gildedrose.expression.Condition.whenSellInLessThanOrEquals;
import static com.gildedrose.expression.Quantity.by;
import static com.gildedrose.policy.rules.QualityImprovesEachDay.qualityImprovesEachDay;
import static com.gildedrose.policy.rules.QualityIsZero.qualityIsZero;

public class BackstagePassPolicy extends GeneralItemPolicy {

    public BackstagePassPolicy() {
        super();
    }

    @Override
    public void qualityChangeWhenSellInLessThanOrEqualsZeroDays() {
        addPolicy(qualityIsZero(whenSellInLessThanOrEquals(0)));
    }

    @Override
    public void qualityChangeWhenSellInGreaterThanZeroDays() {
        addPolicy(qualityImprovesEachDay(by(1), whenSellInGreaterThan(10)));
        addPolicy(qualityImprovesEachDay(by(2), whenSellInLessThanOrEquals(10), whenSellInGreaterThan(5)));
        addPolicy(qualityImprovesEachDay(by(3), whenSellInLessThanOrEquals(5), whenSellInGreaterThan(0)));
    }
}
