import java.io.*;
import java.net.*;

public class java_21350_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected!");

                // Start a new thread to handle the client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket clientSocket;

    public java_21350_SocketServer_A03(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                // Assume the client is sending the username followed by the message
                // This is a simple example, actual use cases would involve parsing and sanitizing the input
                String sanitizedUsername = sanitizeInput(clientMessage.split(" ")[0]);
                String sanitizedMessage = sanitizeInput(clientMessage.split(" ")[1]);

                // Now we're sending a response back to the client
                String responseMessage = "You said: " + sanitizedMessage + " by " + sanitizedUsername;
                writer.println(responseMessage);
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String sanitizeInput(String input) {
        // Here you can add logic to sanitize the input against injection attacks
        // This is a basic example, actual use cases would involve more complex sanitization
        return input;
    }
}