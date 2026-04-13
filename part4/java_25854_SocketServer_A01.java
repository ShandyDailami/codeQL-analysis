import java.io.*;
import java.net.*;

public class java_25854_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            // Print the client's IP
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " has connected.");

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Receive a message from the client
            String message = input.readUTF();

            // Check if the message is valid
            if (isValid(message)) {
                System.out.println("Message received: " + message);

                // Send a response back to the client
                String response = "Message received: " + message;
                output.writeUTF(response);
            } else {
                System.out.println("Invalid message received: " + message);

                // If the message is not valid, send an error response
                String response = "Invalid message: " + message;
                output.writeUTF(response);
            }

            // Close the connection
            socket.close();
        }
    }

    // A function to validate the received message
    private static boolean isValid(String message) {
        // Implementation of the validation logic here.
        // For the purpose of this example, let's assume that all valid messages are allowed.
        return true;
    }
}