package com.gildedrose.policies;

import static com.gildedrose.condition.Condition.sellInGreaterThan;
import static com.gildedrose.condition.Condition.sellInLessThanOrEquals;
import static com.gildedrose.policies.rules.QualityDegradesEachDay.qualityDegradesBy2EachDay;
import static com.gildedrose.policies.rules.QualityDegradesEachDay.qualityDegradesEachDay;
import static com.gildedrose.policies.rules.QualityImprovesEachDay.qualityImprovesBy2EachDay;
import static com.gildedrose.policies.rules.QualityImprovesEachDay.qualityImprovesEachDay;

public class AgedBriePolicy extends BaseItemPolicy {

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
