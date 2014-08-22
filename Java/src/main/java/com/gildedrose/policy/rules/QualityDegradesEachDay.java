package com.gildedrose.policy.rules;

import com.gildedrose.Item;
import com.gildedrose.expression.Condition;
import com.gildedrose.expression.Quantity;

public class QualityDegradesEachDay implements UpdateRule {

    private Quantity quantity;
    private Condition[] conditions;

    protected QualityDegradesEachDay(Quantity quantity, Condition ... conditions) {
        this.conditions = conditions;
        this.quantity = quantity;
    }

    public void apply(Item item) {

        boolean conditionsSatisfied = true;
        for(Condition condition: conditions) {
            if(!condition.eval(item)) {
                conditionsSatisfied = false;
            }
        }

        if(conditionsSatisfied) {
            item.quality = item.quality - quantity.getValue();
        }
    }

    public static QualityDegradesEachDay qualityDegradesEachDay(Quantity quantity, Condition ... conditions) {
        return new QualityDegradesEachDay(quantity, conditions);
    }

}
