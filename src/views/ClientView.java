package views;

import controllers.ClientController;
import model.Client;
import model.Hotel;
import utils.Validator;

import java.util.Scanner;

public class ClientView {

    ClientController clientController;
    Client clientModel;
    Hotel hotelModel;
    Scanner scanner;
    String name;
    int numberNight;
    int numberSubject;
    int numberStar;

    public ClientView(ClientController clientController, Client clientModel, Hotel hotelModel) {
        this.clientController = clientController;
        this.clientModel = clientModel;
        this.hotelModel = hotelModel;
    }

    public void inputData(){
        scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        name = Validator.validateString(scanner);
        clientModel.setName(name);

        System.out.print("Введите коллисество ночей: ");
        numberNight = Validator.validateIntInput(scanner);
        hotelModel.setNumberNight(numberNight);

        System.out.print("Введите количество проживающих: ");
        numberSubject = Validator.validateIntInput(scanner);
        clientModel.setNumberClient(numberSubject);

        System.out.print("Введите колличество звезд отеля: ");
        numberStar = Validator.validateHotelStars(scanner);
        hotelModel.setNumberStar(numberStar);

        scanner.close();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
