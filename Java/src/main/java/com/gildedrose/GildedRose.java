package com.gildedrose;

import com.gildedrose.policy.*;

class GildedRose {

    Item[] items;

    private GeneralItemPolicy generalItemPolicy = new GeneralItemPolicy();
    private AgedBriePolicy agedBriePolicy = new AgedBriePolicy();
    private BackstagePassPolicy backstagePassPolicy = new BackstagePassPolicy();
    private SulfurasPolicy sulfurasPolicy = new SulfurasPolicy();


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQualityV2() {
        for(Item item: items) {
            switch (item.name) {
                case "Aged Brie":
                    agedBriePolicy.apply(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    backstagePassPolicy.apply(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    sulfurasPolicy.apply(item);
                    break;
                default: generalItemPolicy.apply(item);
            }
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
