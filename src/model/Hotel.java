package model;

import base.PriceNight;
import base.TotalPrice;

public class Hotel implements PriceNight, TotalPrice {

    int numberNight;

    @Override
    public double priceNight(double price, double numberTax, double starsTax) {
        return price * numberTax * starsTax;
    }

    @Override
    public double totalPrice(double priceNight, int numberNight) {
        return priceNight * numberNight;
    }
}
