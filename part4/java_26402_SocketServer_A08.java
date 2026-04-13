import java.io.*;
import java.net.*;
import java.util.*;

public class java_26402_SocketServer_A08 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());
                clients.add(client);
                handleClient(client);
            }
        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }

    private static void handleClient(Socket client) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            String message;
            while ((message = in.readUTF()) != null) {
                if (isSecure(message)) {
                    System.out.println("Received secure message: " + message);
                } else {
                    System.out.println("Received message: " + message);
                }
                out.writeUTF("Server received message: " + message);
            }
        } catch (IOException e) {
            System.err.println("Failed to handle client: " + e.getMessage());
            clients.remove(client);
        }
    }

    private static boolean isSecure(String message) {
        // Implementation of secure message checking goes here
        // This is a placeholder and will depend on the specific requirements
        return true;
    }
}