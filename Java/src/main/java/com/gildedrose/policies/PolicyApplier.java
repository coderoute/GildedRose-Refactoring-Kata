package com.gildedrose.policies;

import com.gildedrose.Item;

public class PolicyApplier {

    public static void apply(Item item, UpdatePolicy ... policies) {
        for (UpdatePolicy policy: policies) {
           policy.apply(item);
        }
    }
}
