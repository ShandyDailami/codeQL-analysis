import java.io.*;
import java.net.*;

public class java_05649_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Port 8080 is used for this example
            System.out.println("Waiting for client connection...");

            Socket socket = serverSocket.accept(); // Accept a client connection

            System.out.println("Client connected!");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String messageFromClient;
            while((messageFromClient = reader.readLine()) != null) {
                System.out.println("Received message from client: " + messageFromClient);

                // Here you can add some security-sensitive operations like checking if the message is a command to exit or handle the message in another way

                String responseMessage = "Hello, client!";
                writer.writeBytes(responseMessage + "\n"); // Send a response back to the client
                writer.flush();
            }

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}