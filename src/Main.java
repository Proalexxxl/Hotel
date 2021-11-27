import controllers.AppController;
import controllers.ClientController;
import model.Client;
import model.Hotel;
import views.ClientView;

public class Main {

    private static ClientController clientController;

    public static void main(String[] args) {
        Client clientModel = new Client();
        Hotel hotelModel = new Hotel();
        ClientView clientView = new ClientView(clientController, clientModel, hotelModel);
        clientController = new ClientController(clientView);
        clientController.runApp();
    }
}
