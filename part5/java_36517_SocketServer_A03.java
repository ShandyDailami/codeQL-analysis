import java.io.*;
import java.net.*;

public class java_36517_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Port 8080 is arbitrary
        System.out.println("Server started. Waiting for connections...");

        while (true) {
            Socket socket = serverSocket.accept(); // Accept a new connection
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF(); // Read a message from the client
            System.out.println("Received: " + message);

            String response = processInput(message); // Process the input for security
            dataOutputStream.writeUTF(response); // Send a response back to the client

            socket.close();
        }
    }

    private static String processInput(String input) {
        // This is a placeholder for a real-world application.
        // In a real-world application, this method would be responsible for sanitizing and validating input.
        return "Received: " + input;
    }
}