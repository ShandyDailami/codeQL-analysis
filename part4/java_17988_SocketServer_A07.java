import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17988_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket client;

    public java_17988_SocketServer_A07(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams
            java.io.PrintWriter out = new java.io.PrintWriter(client.getOutputStream(), true);
            java.io.BufferedReader in = new java.io.BufferedReader(
                    new java.io.InputStreamReader(client.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // Authentication
                if ("auth".equals(inputLine)) {
                    out.println("200 OK");
                } else {
                    out.println("401 Unauthorized");
                }
            }

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}