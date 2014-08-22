package com.gildedrose.policy;

import com.gildedrose.policy.rules.QualityIsNeverNegative;
import com.gildedrose.policy.rules.QualityNeverIncreasesBeyond50;
import com.gildedrose.policy.rules.SellInGivenDays;

import static com.gildedrose.expression.Condition.whenSellInGreaterThan;
import static com.gildedrose.expression.Condition.whenSellInLessThanOrEquals;
import static com.gildedrose.expression.Quantity.by;
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
        addPolicy(qualityDegradesEachDay(by(2),whenSellInLessThanOrEquals(0)));
    }

    public void qualityChangeWhenSellInGreaterThanZeroDays() {
        addPolicy(qualityDegradesEachDay(by(1),whenSellInGreaterThan(0)));
    }
}
