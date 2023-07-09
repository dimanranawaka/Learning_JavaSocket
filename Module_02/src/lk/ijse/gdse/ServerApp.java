package lk.ijse.gdse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {

        // Wrap all the code in a try block to catch any IOException that may occur during network communication
        try {
            // Define port number that the server will listen on
            final int PORT = 3000;

            // Create a server socket on the defined port
            ServerSocket serverSocket = new ServerSocket(PORT);

            // Output to console indicating that the server is running
            System.out.println("Server is running in port : " + PORT);

            // The server waits for a client connection using accept(). Program execution will pause here until a connection is made
            Socket localSocket = serverSocket.accept();
            System.out.println("Client Accepted!");

            // Output stream - used for sending data to the client
            DataOutputStream dataOutputStream = new DataOutputStream(localSocket.getOutputStream());

            // Input stream - used for receiving data from the client
            DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());

            // Reader for reading input from the user in the server-side console
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            // Variables to store the incoming message from the client and the reply from the server
            String message = " ", reply = "";

            // Server starts a loop that runs until the client sends a "finish" message
            while (!message.equals("finish")) {

                // The server reads a message from the client
                message = dataInputStream.readUTF();
                // Print the client's message to the console
                System.out.println(message);

                // The server reads a reply from the console
                reply = bufferedReader.readLine();

                // The server sends the reply to the client
                dataOutputStream.writeUTF(reply);

                // Flushes the output stream, effectively sending any buffered output bytes to the client
                dataOutputStream.flush();
            }
            // Close all the resources after usage
            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            // If an IOException is caught, print its stack trace for debugging purposes
            e.printStackTrace();
        }
    }
}
