package lk.ijse.gdse;

import java.io.IOException;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) throws IOException {

        final int PORT = 3000;

        Socket socket = new Socket("localhost",PORT); // Client
    }
}
