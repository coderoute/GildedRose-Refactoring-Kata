package com.gildedrose.policy;

import com.gildedrose.Item;
import com.gildedrose.policy.rules.UpdateRule;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseItemPolicy {

    private List<UpdateRule> policyList = new ArrayList<>();

    public void addPolicy(UpdateRule policy) {
        policyList.add(policy);
    }

    public void apply(Item item) {
        PolicyApplier.apply(item, policyList);
    }
}
