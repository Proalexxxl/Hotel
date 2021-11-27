package controllers;

import model.Client;
import model.Hotel;
import utils.Rounder;
import views.ClientView;

public class ClientController {

    ClientView clientView;
    Client clientModel;
    Hotel hotelModel;
    double starsRate;
    double numbersClientRate;
    double price;
    double priceNight;
    double totalPrice;
    String totalPriceRound;
    String pattern;
    String output;

    public ClientController(ClientView clientView, Client clientModel, Hotel hotelModel) {
        this.clientView = clientView;
        this.clientModel = clientModel;
        this.hotelModel = hotelModel;
    }

    public void runApp() {
        starsRate = 1.2;
        numbersClientRate = 1.3;
        price = 399.99;
        pattern = "#.00";

        clientView.inputData();

        priceNight = hotelModel.priceNight(price, numbersClientRate, clientModel.getNumberClient(), starsRate, hotelModel.getNumberStar());
        totalPrice = hotelModel.totalPrice(priceNight, hotelModel.getNumberNight());

        totalPriceRound = Rounder.round(totalPrice, pattern);

        output = "Отель \"Марсель\" \nПериод проживания: " + hotelModel.getNumberNight() +
                    " ночей.\nСтоимость проживания за весь период: " + totalPriceRound + " грн.";

        clientView.getOutput(output);
    }
}
