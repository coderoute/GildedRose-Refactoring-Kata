package com.gildedrose.policy;

import com.gildedrose.policy.rules.QualityIsNeverNegative;
import com.gildedrose.policy.rules.QualityNeverIncreasesBeyond50;
import com.gildedrose.policy.rules.SellInGivenDays;

import static com.gildedrose.condition.Condition.sellInGreaterThan;
import static com.gildedrose.condition.Condition.sellInLessThanOrEquals;
import static com.gildedrose.policy.rules.QualityDegradesEachDay.qualityDegradesBy2EachDay;
import static com.gildedrose.policy.rules.QualityDegradesEachDay.qualityDegradesEachDay;

public class GeneralItemPolicy extends BaseItemPolicy {

    private SellInGivenDays sellInGivenDays = new SellInGivenDays();
    private QualityNeverIncreasesBeyond50 qualityNeverIncreasesBeyond50 = new QualityNeverIncreasesBeyond50();
    private QualityIsNeverNegative qualityIsNeverNegative = new QualityIsNeverNegative();

    public GeneralItemPolicy() {
        qualityChangeWhenSellInGreaterThanZeroDays();
        qualityChangeWhenSellInLessThanOrEqualsZeroDays();
        qualityHasUpperLimit();
        qualityHasLowerLimit();
        sellInGivenDays();
    }

    public void sellInGivenDays() {
        addPolicy(sellInGivenDays);
    }

    public void qualityHasLowerLimit() {
        addPolicy(qualityIsNeverNegative);
    }

    public void qualityHasUpperLimit() {
        addPolicy(qualityNeverIncreasesBeyond50);
    }

    public void qualityChangeWhenSellInLessThanOrEqualsZeroDays() {
        addPolicy(qualityDegradesBy2EachDay(sellInLessThanOrEquals(0)));
    }

    public void qualityChangeWhenSellInGreaterThanZeroDays() {
        addPolicy(qualityDegradesEachDay(sellInGreaterThan(0)));
    }
}
