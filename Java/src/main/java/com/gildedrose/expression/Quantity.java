package com.gildedrose.expression;

public class Quantity {

    private int value;

    private Quantity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Quantity by(int quantity) {
        return new Quantity(quantity);
    }
}
