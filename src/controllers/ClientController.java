package controllers;

import views.ClientView;

public class ClientController {

    ClientView clientView;

    public ClientController(ClientView clientView) {
        this.clientView = clientView;
    }

    public void runApp() {
        clientView.inputData();
    }
}
