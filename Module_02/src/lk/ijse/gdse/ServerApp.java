package lk.ijse.gdse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) throws IOException {

        final int PORT = 3000;

        ServerSocket serverSocket = new ServerSocket(PORT); // Server Socket For listening

        System.out.println("Server is running in port : "+PORT);

        Socket localSocket = serverSocket.accept(); // For accepting client's socket to keep the program running
        System.out.println("Client Accepted!");


    }
}
