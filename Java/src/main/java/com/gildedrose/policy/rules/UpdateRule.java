package com.gildedrose.policy.rules;

import com.gildedrose.Item;

public interface UpdateRule {

    /**
     * Updates the item's 'sell in' value
     * @param item
     */
    void apply(Item item);
}
