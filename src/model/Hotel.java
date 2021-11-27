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
    public double priceNight(double price, double numberClientRate, int numberClient, double starsRate, int numberStar) {
        return price * numberClientRate * numberClient * starsRate * numberStar;
    }

    @Override
    public double totalPrice(double priceNight, int numberNight) {
        return priceNight * numberNight;
    }
}
