import base.ConstantsDB;
import controllers.AppController;
import controllers.ClientController;
import controllers.DBController;
import controllers.EmployeeController;
import model.Client;
import model.Employee;
import views.ClientView;

public class Main {

    private static ClientController clientController;

    public static void main(String[] args) {
        ConstantsDB constantsDB = new ConstantsDB();
        Client clientModel = new Client();
        Employee employeeModel = new Employee();
        ClientView clientView = new ClientView(clientController, clientModel, employeeModel);
        clientController = new ClientController(clientView, clientModel, employeeModel);
        EmployeeController employeeController = new EmployeeController();
        DBController dbController = new DBController(constantsDB);
        AppController appController = new AppController(clientController, employeeController, dbController, constantsDB);

        appController.subjectChoice();
    }
}
