import java.io.*;
import java.net.*;
import java.util.*;

public class java_33530_SocketServer_A08 {
    private static final int PORT = 4445;
    private static Set<Socket> clients = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected from " + client.getRemoteSocketAddress());
                clients.add(client);

                new Handler(client).start();
            }
        } catch (IOException ex) {
            System.out.println("Error in server listening: " + ex.getMessage());
        }
    }

    private static class Handler extends Thread {
        private final Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_33530_SocketServer_A08(Socket client) {
            this.client = client;
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException ex) {
                client.close();
                clients.remove(client);
                System.out.println("Error setting up I/O for a client: " + ex.getMessage());
            }
        }

        public void run() {
            try {
                String request;
                while ((request = in.readLine()) != null) {
                    out.println("Server received: " + request);
                    out.flush();

                    // Check if client is still connected
                    if (!client.isConnected()) {
                        clients.remove(client);
                        return;
                    }
                }
            } catch (IOException ex) {
                clients.remove(client);
                System.out.println("Error handling client: " + ex.getMessage());
            }
        }
    }
}