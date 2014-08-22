package com.gildedrose.policy;

import com.gildedrose.Item;
import com.gildedrose.policy.rules.UpdateRule;

import java.util.List;

public class PolicyApplier {

    public static void apply(Item item, List<UpdateRule> policies) {
        for (UpdateRule policy: policies) {
           policy.apply(item);
        }
    }
}
