package com.codingstones.bdd.vat;

public class VATCalculator {
    public float calculateTotal(String product, int price) {
        if (product.equals("diapers")) return (float) (price * 1.21);
        if (product.equals("bread")) return (float) (price * 1.04);
        if (product.equals("wine")) return (float) (price * 1.10);
        return -1;
    }
}
