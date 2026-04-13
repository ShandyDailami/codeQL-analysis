import java.io.*;
import java.net.*;
import java.util.*;

public class java_04488_SocketServer_A08 {
    private static final int PORT = 8080;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);
            while (true) {
                Socket client = server.accept();
                clients.add(client);
                System.out.println("Client connected from: " + client.getRemoteSocketAddress());
                handleClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket client) {
        Thread thread = new Thread(() -> handleRequest(client));
        thread.start();
    }

    private static void handleRequest(Socket client) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Example of a security-sensitive operation related to A08_IntegrityFailure
                if ("exit".equals(message)) {
                    clients.remove(client);
                    out.println("Client disconnected");
                    break;
                }
                // Sending a response back to the client
                out.println("Server response: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (clients.contains(client)) {
                clients.remove(client);
            }
        }
    }
}