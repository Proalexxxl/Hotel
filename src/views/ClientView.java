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
        name = Validator.validateName(scanner);
        clientModel.setName(name);

        System.out.print("Введите коллисество ночей: ");
        numberNight = Validator.validateQuantityInput(scanner);
        hotelModel.setNumberNight(numberNight);

        System.out.print("Введите количество проживающихж ");
        numberSubject = Validator.validateQuantityInput(scanner);
        clientModel.setNumberSubject(numberSubject);

        System.out.print("Введите колличество звезд отеля: ");
        numberStar = Validator.validateQuantityInput(scanner);
        hotelModel.setNumberStar(numberStar);

        scanner.close();
    }
}
