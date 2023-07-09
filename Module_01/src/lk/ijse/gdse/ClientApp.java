package lk.ijse.gdse;

import java.io.IOException;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8000);// Client socket to request from Server

    }
}
