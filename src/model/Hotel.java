package model;

import base.PriceNight;
import base.TotalPrice;

public class Hotel implements PriceNight, TotalPrice {

    int numberNight;
    int numberStar;

    public int getNumberStar() {
        return numberStar;
    }

    public void setNumberStar(int numberStar) {
        this.numberStar = numberStar;
    }

    public int getNumberNight() {
        return numberNight;
    }

    public void setNumberNight(int numberNight) {
        this.numberNight = numberNight;
    }

    @Override
    public double priceNight(double price, double numberTax, double starsTax) {
        return price * numberTax * starsTax;
    }

    @Override
    public double totalPrice(double priceNight, int numberNight) {
        return priceNight * numberNight;
    }
}
