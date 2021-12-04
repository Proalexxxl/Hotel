package controllers;

import java.util.Scanner;

public class AppController {

    String subject;
    ClientController clientController;
    EmployeeController employeeController;
    Scanner scanner;
    boolean variableEquals;

    public AppController(ClientController clientController, EmployeeController employeeController) {
        this.clientController = clientController;
        this.employeeController = employeeController;
    }

    public void subjectChoice(){
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
