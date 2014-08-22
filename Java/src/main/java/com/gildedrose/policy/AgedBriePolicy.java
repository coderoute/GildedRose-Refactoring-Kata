package com.gildedrose.policy;

import static com.gildedrose.expression.Condition.whenSellInGreaterThan;
import static com.gildedrose.expression.Condition.whenSellInLessThanOrEquals;
import static com.gildedrose.expression.Quantity.by;
import static com.gildedrose.policy.rules.QualityImprovesEachDay.qualityImprovesEachDay;

public class AgedBriePolicy extends GeneralItemPolicy {

    public AgedBriePolicy() {
        super();
    }

    @Override
    public void qualityChangeWhenSellInLessThanOrEqualsZeroDays() {
        addPolicy(qualityImprovesEachDay(by(2), whenSellInLessThanOrEquals(0)));
    }

    @Override
    public void qualityChangeWhenSellInGreaterThanZeroDays() {
        addPolicy(qualityImprovesEachDay(by(1), whenSellInGreaterThan(0)));
    }
}
