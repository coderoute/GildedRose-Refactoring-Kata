package com.gildedrose.policy.rules;

import com.gildedrose.Item;
import com.gildedrose.condition.Condition;

public class QualityDegradesEachDay implements UpdateRule {

    private int degradationMultiple;
    private Condition[] conditions;

    protected QualityDegradesEachDay(Condition ... conditions) {
        this(1, conditions);
    }

    protected QualityDegradesEachDay(int degradationMultiple, Condition ... conditions) {
        this.conditions = conditions;
        this.degradationMultiple = degradationMultiple;
    }

    public void apply(Item item) {

        boolean conditionsSatisfied = true;
        for(Condition condition: conditions) {
            if(!condition.eval(item)) {
                conditionsSatisfied = false;
            }
        }

        if(conditionsSatisfied) {
            item.quality = item.quality - degradationMultiple;
        }
    }

    public static QualityDegradesEachDay qualityDegradesEachDay(Condition ... conditions) {
        return new QualityDegradesEachDay(conditions);
    }

    public static QualityDegradesEachDay qualityDegradesBy2EachDay(Condition ... conditions) {
        return new QualityDegradesEachDay(2, conditions);
    }

}
