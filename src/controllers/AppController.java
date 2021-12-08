package controllers;

import base.ConstantsDB;
import java.util.Scanner;

public class AppController {

    String subject;
    ClientController clientController;
    EmployeeController employeeController;
    Scanner scanner;
    boolean variableEquals;
    DBController dbController;
    ConstantsDB constantsDB;

    public AppController(ClientController clientController, EmployeeController employeeController, DBController dbController, ConstantsDB constantsDB) {
        this.clientController = clientController;
        this.employeeController = employeeController;
        this.dbController = dbController;
        this.constantsDB = constantsDB;
    }

    public void subjectChoice() {
        if (dbController.isBaseExist()) {
            System.out.println("База: " + constantsDB.DB_NAME + " существует.");
        } else {
            dbController.createDatabase(constantsDB.DB_NAME);
            System.out.println("База данных: " + constantsDB.DB_NAME + " создана.");
        }

        variableEquals = true;
        scanner = new Scanner(System.in);
        System.out.println("Введите субъекта (клиент/сотрудник): ");
        subject  = scanner.nextLine().trim().toLowerCase();

        while (!(subject.equals("клиент") || subject.equals("сотрудник"))) {
            System.out.printf("%s - не соответствует критериям! Повторите ввод: ", subject);
            subject = scanner.nextLine().trim().toLowerCase();
        }

        subject = subject.toLowerCase().trim();

        switch (subject) {
            case "клиент" -> clientController.runAppClient();
            case "сотрудник" -> employeeController.runAppEmployee();
            default -> System.out.println("Неверный ввод.");
        }

        scanner.close();
    }
}

