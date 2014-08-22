package com.gildedrose.policy;

import static com.gildedrose.condition.Condition.sellInGreaterThan;
import static com.gildedrose.condition.Condition.sellInLessThanOrEquals;
import static com.gildedrose.policy.rules.QualityImprovesEachDay.qualityImprovesBy2EachDay;
import static com.gildedrose.policy.rules.QualityImprovesEachDay.qualityImprovesEachDay;

public class AgedBriePolicy extends GeneralItemPolicy {

    public AgedBriePolicy() {
        super();
    }

    @Override
    public void qualityChangeWhenSellInLessThanOrEqualsZeroDays() {
        addPolicy(qualityImprovesBy2EachDay(sellInLessThanOrEquals(0)));
    }

    @Override
    public void qualityChangeWhenSellInGreaterThanZeroDays() {
        addPolicy(qualityImprovesEachDay(sellInGreaterThan(0)));
    }
}
