package com.gildedrose.policies.rules;

import com.gildedrose.Item;

public interface UpdatePolicy {

    /**
     * Updates the item's 'sell in' value
     * @param item
     */
    void apply(Item item);
}
