import java.io.*;
import java.net.*;
import java.util.*;

public class java_12057_SocketServer_A07 {

    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(65535); // using arbitrary port
            System.out.println("Server listening on port " + server.getLocalPort() + "...");
            while (true) {
                Socket client = server.accept();
                System.out.println("Connected to " + client.getRemoteSocketAddress());

                clients.add(client);

                // Handle client connection in a new thread
                new Handler(client).start();
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

    private static class Handler extends Thread {
        private Socket client;

        public java_12057_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // Read request from client
                String request = in.readLine();
                System.out.println("Received: " + request);

                // Simulate authentication failure
                if (request.equals("auth failure")) {
                    out.println("FAILURE");
                } else {
                    out.println("SUCCESS");
                }

                // Close connection
                client.close();
                clients.remove(client);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}