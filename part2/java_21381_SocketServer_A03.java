import java.io.*;
import java.net.*;

public class java_21381_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a new server socket at port 1234
            ServerSocket serverSocket = new ServerSocket(1234);

            // Accept a new client socket
            Socket clientSocket = serverSocket.accept();

            // Create a new input stream from the socket
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());

            // Read the client message
            String message = input.readUTF();

            // Print the client message
            System.out.println("Received: " + message);

            // Close the input stream and the client socket
            input.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}