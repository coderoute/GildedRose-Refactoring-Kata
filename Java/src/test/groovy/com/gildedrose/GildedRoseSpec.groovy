package com.gildedrose

import spock.lang.Specification
import spock.lang.Unroll

class GildedRoseSpec extends Specification {

    public static final String ITEM = "item"
    public static final String AGED_BRIE = "Aged Brie"
    public static final String AGED_BRIE_INCREASES_IN_QUALITY_WITH_AGE = "'Aged Brie' actually increases in Quality the older it gets"
    public static final String QUALITY_DEGRADES_TWICE_AS_FAST_AFTER_SELL_BY_DATE = "Once the sell by date has passed, Quality degrades twice as fast"
    public static final String QUALITY_OF_AN_ITEM_IS_NEVER_NEGATIVE = "The Quality of an item is never negative"
    public static final String QUALITY_DEGRADES_EACH_DAY_FOR_EVERY_ITEM = "At the end of each day our system lowers both values for every item"
    public static final String QUALITY_OF_AN_ITEM_NEVER_INCREASES_BEYOND_50 = "The Quality of an item never increases beyond 50"
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros"
    public static final String SULFURAS_NEVER_HAS_TO_BE_SOLD_OR_REDUCES_IN_VALUE = "'Sulfuras', being a legendary item, never has to be sold or decreases in Quality"
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    public static final String CONJURED = "Conjured"
    public static final String CONJURED_ITEMS_DEGRADE_TWICE_AS_FAST = "'Conjured' items degrade in Quality twice as fast as normal items"

    @Unroll("#name - #ruleDescription")
    def "check rule"() {
        def item = new Item(name, sellIn, quality)
        def underTest = new GildedRose(item)
        underTest.updateQuality()

        expect:
        item.name == name
        item.sellIn == expectedSellInAfterUpdate
        item.quality == expectedQualityAfterUpdate

        where:
        name             | sellIn | quality | expectedSellInAfterUpdate | expectedQualityAfterUpdate | ruleDescription
        ITEM             | 1      | 1       | 0                         | 0                          | "Assertion1: " + QUALITY_DEGRADES_EACH_DAY_FOR_EVERY_ITEM
        ITEM             | 0      | 2       | -1                        | 0                          | "Assertion2: " + QUALITY_DEGRADES_TWICE_AS_FAST_AFTER_SELL_BY_DATE
        ITEM             | -1     | 3       | -2                        | 1                          | "Assertion3: " + QUALITY_DEGRADES_TWICE_AS_FAST_AFTER_SELL_BY_DATE
        ITEM             | 2      | 0       | 1                         | 0                          | "Assertion4: " + QUALITY_OF_AN_ITEM_IS_NEVER_NEGATIVE
        ITEM             | 0      | 1       | -1                        | 0                          | "Assertion5: " + QUALITY_OF_AN_ITEM_IS_NEVER_NEGATIVE
        AGED_BRIE        | 1      | 0       | 0                         | 1                          | "Assertion6: " + AGED_BRIE_INCREASES_IN_QUALITY_WITH_AGE
        AGED_BRIE        | 0      | 1       | -1                        | 3                          | "Assertion7: " + AGED_BRIE_INCREASES_IN_QUALITY_WITH_AGE
        AGED_BRIE        | -1     | 0       | -2                        | 2                          | "Assertion8: " + AGED_BRIE_INCREASES_IN_QUALITY_WITH_AGE
        AGED_BRIE        | -25    | 50      | -26                       | 50                         | "Assertion9: " + QUALITY_OF_AN_ITEM_NEVER_INCREASES_BEYOND_50
        SULFURAS         | 1      | 1       | 1                         | 1                          | "Assertion10: " + SULFURAS_NEVER_HAS_TO_BE_SOLD_OR_REDUCES_IN_VALUE
        SULFURAS         | 0      | 0       | 0                         | 0                          | "Assertion11: " + SULFURAS_NEVER_HAS_TO_BE_SOLD_OR_REDUCES_IN_VALUE
        SULFURAS         | -1     | 0       | -1                        | 0                          | "Assertion12: " + SULFURAS_NEVER_HAS_TO_BE_SOLD_OR_REDUCES_IN_VALUE
        SULFURAS         | -1     | 80      | -1                        | 80                         | "Assertion13: " + "Sulfuras has a Quality of 80 that never alters"
        BACKSTAGE_PASSES | 11     | 0       | 10                        | 1                          | "Assertion14: " + "Backstage pass quality increases like Aged Brie, when sellIn > 10"
        BACKSTAGE_PASSES | 10     | 0       | 9                         | 2                          | "Assertion15: " + "Backstage pass quality increases by 2, when sellIn <= 10 and > 5"
        BACKSTAGE_PASSES | 6      | 0       | 5                         | 2                          | "Assertion16: " + "Backstage pass quality increases by 2, when sellIn <= 10 and > 5"
        BACKSTAGE_PASSES | 5      | 0       | 4                         | 3                          | "Assertion17: " + "Backstage pass quality increases by 2, when sellIn <= 10 and > 5"
        BACKSTAGE_PASSES | 1      | 0       | 0                         | 3                          | "Assertion18: " + "Backstage pass quality increases by 2, when sellIn <= 10 and > 5"
        BACKSTAGE_PASSES | 1      | 50      | 0                         | 50                         | "Assertion19: " +  QUALITY_OF_AN_ITEM_NEVER_INCREASES_BEYOND_50
        BACKSTAGE_PASSES | 1      | 49      | 0                         | 50                         | "Assertion20: " + QUALITY_OF_AN_ITEM_NEVER_INCREASES_BEYOND_50
        BACKSTAGE_PASSES | 6      | 49      | 5                         | 50                         | "Assertion21: " + QUALITY_OF_AN_ITEM_NEVER_INCREASES_BEYOND_50
        BACKSTAGE_PASSES | 12     | 50      | 11                        | 50                         | "Assertion22: " + QUALITY_OF_AN_ITEM_NEVER_INCREASES_BEYOND_50
        CONJURED         | 2      | 4       | 1                         | 2                          | "Assertion23: " + CONJURED_ITEMS_DEGRADE_TWICE_AS_FAST
        CONJURED         | 1      | 1       | 0                         | 0                          | "Assertion24: " + QUALITY_OF_AN_ITEM_IS_NEVER_NEGATIVE
        CONJURED         | 0      | 5       | -1                        | 1                          | "Assertion25: " + CONJURED_ITEMS_DEGRADE_TWICE_AS_FAST + " and " + QUALITY_DEGRADES_TWICE_AS_FAST_AFTER_SELL_BY_DATE
        CONJURED         | 2      | 0       | 1                         | 0                          | "Assertion26: " + QUALITY_OF_AN_ITEM_IS_NEVER_NEGATIVE
    }


}
