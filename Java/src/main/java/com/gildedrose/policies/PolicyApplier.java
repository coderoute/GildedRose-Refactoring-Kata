package com.gildedrose.policies;

import com.gildedrose.Item;
import com.gildedrose.policies.rules.UpdatePolicy;

import java.util.List;

public class PolicyApplier {

    public static void apply(Item item, List<UpdatePolicy> policies) {
        for (UpdatePolicy policy: policies) {
           policy.apply(item);
        }
    }
}
