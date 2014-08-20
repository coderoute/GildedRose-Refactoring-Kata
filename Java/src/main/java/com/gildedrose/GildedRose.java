package com.gildedrose;

import com.gildedrose.policies.*;

import static com.gildedrose.condition.Condition.*;
import static com.gildedrose.policies.QualityDegradesEachDay.qualityDegradesBy2EachDay;
import static com.gildedrose.policies.QualityDegradesEachDay.qualityDegradesEachDay;
import static com.gildedrose.policies.QualityImprovesEachDay.qualityImprovesBy3EachDay;
import static com.gildedrose.policies.QualityImprovesEachDay.qualityImprovesEachDay;
import static com.gildedrose.policies.QualityImprovesEachDay.qualityImprovesBy2EachDay;
import static com.gildedrose.policies.QualityIsZero.qualityIsZero;

class GildedRose {

    SellInGivenDays sellInGivenDays = new SellInGivenDays();

    QualityNeverIncreasesBeyond50 qualityNeverIncreasesBeyond50 = new QualityNeverIncreasesBeyond50();

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQualityV2() {
        for(Item item: items) {
            switch (item.name) {
                case "Aged Brie": PolicyApplier.apply(item,
                        qualityImprovesEachDay(sellInGreaterThan(0)),
                        qualityImprovesBy2EachDay(sellInLessThanOrEquals(0)),
                        sellInGivenDays);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    PolicyApplier.apply(item,
                            qualityImprovesEachDay(sellInGreaterThan(10)),
                            qualityImprovesBy2EachDay(sellInLessThanOrEquals(10), sellInGreaterThan(5)),
                            qualityImprovesBy3EachDay(sellInLessThanOrEquals(5), sellInGreaterThan(0)),
                            qualityIsZero(sellInLessThanOrEquals(0)),
                            sellInGivenDays);
                    break;
                default: PolicyApplier.apply(item,
                        qualityDegradesEachDay(sellInGreaterThan(0)),
                        qualityDegradesBy2EachDay(sellInLessThanOrEquals(0)),
                        sellInGivenDays);
            }
            qualityNeverIncreasesBeyond50.apply(item);
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
