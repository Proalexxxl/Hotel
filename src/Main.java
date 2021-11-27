import controllers.AppController;
import model.Client;
import model.Hotel;

public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        Hotel hotel = new Hotel();
        AppController appController = new AppController();
        appController.runApp();
    }
}
