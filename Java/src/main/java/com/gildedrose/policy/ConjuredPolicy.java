package com.gildedrose.policy;

import static com.gildedrose.condition.Condition.sellInGreaterThan;
import static com.gildedrose.condition.Condition.sellInLessThanOrEquals;
import static com.gildedrose.policy.rules.QualityDegradesEachDay.qualityDegradesBy2EachDay;
import static com.gildedrose.policy.rules.QualityDegradesEachDay.qualityDegradesEachDay;

public class ConjuredPolicy extends GeneralItemPolicy {

    @Override
    public void qualityChangeWhenSellInLessThanOrEqualsZeroDays() {
        addPolicy(qualityDegradesBy2EachDay(sellInLessThanOrEquals(0)));
        addPolicy(qualityDegradesBy2EachDay(sellInLessThanOrEquals(0)));
    }

    @Override
    public void qualityChangeWhenSellInGreaterThanZeroDays() {
        addPolicy(qualityDegradesBy2EachDay(sellInGreaterThan(0)));
    }
}
