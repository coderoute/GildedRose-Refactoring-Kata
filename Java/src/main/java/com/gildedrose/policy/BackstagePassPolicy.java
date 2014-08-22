package com.gildedrose.policy;

import static com.gildedrose.condition.Condition.sellInGreaterThan;
import static com.gildedrose.condition.Condition.sellInLessThanOrEquals;
import static com.gildedrose.policy.rules.QualityImprovesEachDay.qualityImprovesBy2EachDay;
import static com.gildedrose.policy.rules.QualityImprovesEachDay.qualityImprovesBy3EachDay;
import static com.gildedrose.policy.rules.QualityImprovesEachDay.qualityImprovesEachDay;
import static com.gildedrose.policy.rules.QualityIsZero.qualityIsZero;

public class BackstagePassPolicy extends GeneralItemPolicy {

    public BackstagePassPolicy() {
        super();
    }

    @Override
    public void qualityChangeWhenSellInLessThanOrEqualsZeroDays() {
        addPolicy(qualityIsZero(sellInLessThanOrEquals(0)));
    }

    @Override
    public void qualityChangeWhenSellInGreaterThanZeroDays() {
        addPolicy(qualityImprovesEachDay(sellInGreaterThan(10)));
        addPolicy(qualityImprovesBy2EachDay(sellInLessThanOrEquals(10), sellInGreaterThan(5)));
        addPolicy(qualityImprovesBy3EachDay(sellInLessThanOrEquals(5), sellInGreaterThan(0)));
    }
}
