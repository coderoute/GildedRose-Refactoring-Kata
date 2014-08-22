package com.gildedrose;

import com.gildedrose.policy.*;

class GildedRose {

    Item[] items;

    private GeneralItemPolicy generalItemPolicy = new GeneralItemPolicy();
    private AgedBriePolicy agedBriePolicy = new AgedBriePolicy();
    private BackstagePassPolicy backstagePassPolicy = new BackstagePassPolicy();
    private SulfurasPolicy sulfurasPolicy = new SulfurasPolicy();
    private ConjuredPolicy conjuredPolicy = new ConjuredPolicy();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
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
                case "Conjured":
                    conjuredPolicy.apply(item);
                    break;
                default: generalItemPolicy.apply(item);
            }
        }
    }
}
