package lk.ijse.gdse;

import java.io.*;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
        // Define the port number on which the client will connect to the server
        final int PORT = 3000;

        // Declare the socket variable outside of the try block so it can be accessed in the finally block
        Socket socket = null;

        try {
            // Establish a socket connection to the server on localhost and the defined port
            socket = new Socket("localhost", PORT);

            // DataOutputStream allows the client to send messages to the server
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // DataInputStream allows the client to receive messages from the server
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            // BufferedReader reads text from an input stream from user input in the console
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            // Variables to store the outgoing message to the server and the response from the server
            String message = "" , reply = "";

            // Client starts a loop that runs until the user inputs "finish"
            while (!message.equals("finish")){

                // The client reads a message from the console
                reply = bufferedReader.readLine();

                // The client sends the message to the server
                dataOutputStream.writeUTF(reply);

                // The client reads a response from the server
                message = dataInputStream.readUTF();

                // Print the server's response to the console
                System.out.println(message);

                // Flushes the output stream, effectively sending any buffered output bytes to the server
                dataOutputStream.flush();
            }

            // Close all the resources after usage
            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();

        }catch (IOException e){
            // If an IOException is caught, print its stack trace for debugging purposes
            e.printStackTrace();
        }
    }
}
