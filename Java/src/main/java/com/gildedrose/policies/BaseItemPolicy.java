package com.gildedrose.policies;

import com.gildedrose.Item;
import com.gildedrose.policies.rules.QualityIsNeverNegative;
import com.gildedrose.policies.rules.QualityNeverIncreasesBeyond50;
import com.gildedrose.policies.rules.SellInGivenDays;
import com.gildedrose.policies.rules.UpdatePolicy;

import java.util.ArrayList;
import java.util.List;

import static com.gildedrose.condition.Condition.sellInGreaterThan;
import static com.gildedrose.condition.Condition.sellInLessThanOrEquals;
import static com.gildedrose.policies.rules.QualityDegradesEachDay.qualityDegradesBy2EachDay;
import static com.gildedrose.policies.rules.QualityDegradesEachDay.qualityDegradesEachDay;

public class BaseItemPolicy {

    private SellInGivenDays sellInGivenDays = new SellInGivenDays();
    private QualityNeverIncreasesBeyond50 qualityNeverIncreasesBeyond50 = new QualityNeverIncreasesBeyond50();
    private QualityIsNeverNegative qualityIsNeverNegative = new QualityIsNeverNegative();

    private List<UpdatePolicy> policyList = new ArrayList<>();

    public BaseItemPolicy() {
        qualityChangeWhenSellInGreaterThanZeroDays();
        qualityChangeWhenSellInLessThanOrEqualsZeroDays();
        qualityHasUpperLimit();
        qualityHasLowerLimit();
        sellInGivenDays();
    }

    public void addPolicy(UpdatePolicy policy) {
        policyList.add(policy);
    }

    public void apply(Item item) {
        PolicyApplier.apply(item, policyList);
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
