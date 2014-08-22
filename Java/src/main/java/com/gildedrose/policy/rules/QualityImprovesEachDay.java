package com.gildedrose.policy.rules;

import com.gildedrose.condition.Condition;

public class QualityImprovesEachDay extends QualityDegradesEachDay {

    private QualityImprovesEachDay(Condition ... conditions) {
        this(1, conditions);
    }

    private QualityImprovesEachDay(int multiple, Condition ... conditions) {
        super(-multiple, conditions);
    }

    public static QualityImprovesEachDay qualityImprovesEachDay(Condition ... conditions) {
        return new QualityImprovesEachDay(conditions);
    }

    public static QualityImprovesEachDay qualityImprovesBy2EachDay(Condition... conditions) {
        return new QualityImprovesEachDay(2, conditions);
    }

    public static QualityImprovesEachDay qualityImprovesBy3EachDay(Condition... conditions) {
        return new QualityImprovesEachDay(3, conditions);
    }
}
