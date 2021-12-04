package controllers;

import model.Client;
import model.Employee;
import utils.Rounder;
import views.ClientView;

public class ClientController {

    ClientView clientView;
    Client clientModel;
    Employee employeeModel;
    double starsRate;
    double numbersClientRate;
    double price;
    double priceNight;
    double totalPrice;
    String totalPriceRound;
    String pattern;
    String output;

    public ClientController(ClientView clientView, Client clientModel, Employee employeeModel) {
        this.clientView = clientView;
        this.clientModel = clientModel;
        this.employeeModel = employeeModel;
    }

    public void runAppClient() {
        starsRate = 1.2;
        numbersClientRate = 1.3;
        price = 399.99;
        pattern = "#.00";

        clientView.inputData();

        priceNight = employeeModel.priceNight(price, numbersClientRate, clientModel.getNumberClient(), starsRate, employeeModel.getNumberStar());
        totalPrice = employeeModel.totalPrice(priceNight, employeeModel.getNumberNight());

        totalPriceRound = Rounder.round(totalPrice, pattern);

        output = "Отель \"Марсель\" \nПериод проживания: " + employeeModel.getNumberNight() +
                    " ночей.\nСтоимость проживания за весь период: " + totalPriceRound + " грн.";

        clientView.getOutput(output);
    }
}
