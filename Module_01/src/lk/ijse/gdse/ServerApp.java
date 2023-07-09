package lk.ijse.gdse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        final int PORT = 8000;
        ServerSocket serverSocket = new ServerSocket(8000); //Server Socket for listening

        System.out.println("Server is running in port"+ PORT);
    }
}
