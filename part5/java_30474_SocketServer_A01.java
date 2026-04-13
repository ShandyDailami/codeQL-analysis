import java.io.*;
import java.net.*;
import java.util.*;

public class java_30474_SocketServer_A01 {
    private static final String SERVER_MESSAGE = "Welcome to the server!";
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345); // port number
            System.out.println("Server started. Waiting for client connections...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");
                clients.add(socket);
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send a welcome message to the client
            writer.println(SERVER_MESSAGE);

            // Check for client commands
            String clientInput;
            while ((clientInput = reader.readLine()) != null) {
                System.out.println("Client says: " + clientInput);
                if (clientInput.equals("exit")) {
                    clients.remove(socket);
                    writer.println("Closing connection...");
                    socket.close();
                    break;
                } else {
                    // Add security-sensitive operations here, e.g., encrypt/decrypt messages
                    // ...
                    // Send a response back to the client
                    writer.println("Server says: Hello, client!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}