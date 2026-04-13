import java.io.*;
import java.net.*;

public class java_38183_SocketServer_A08 {
    private static int DEFAULT_PORT = 8888;
    private static ServerSocket server;

    public static void main(String[] args) {
        startServer(DEFAULT_PORT);
    }

    private static void startServer(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());
                handleClient(client);
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
            ex.printStackTrace();
       
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException ex) {
                    System.out.println("Error closing server: " + ex.getMessage());
                }
            }
        }
    }

    private static void handleClient(Socket client) {
        // Create a new thread for each client connection
        Thread thread = new Thread(new ClientHandler(client));
        thread.start();
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_38183_SocketServer_A08(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                // Implement logic for integrity-sensitive operations here (e.g. check if the clientMessage matches a known pattern)

                // Respond to the client
                out.println("Server received your message: " + clientMessage);
            }

            client.close();
        } catch (IOException ex) {
            System.out.println("Error handling client: " + ex.getMessage());
        }
    }
}