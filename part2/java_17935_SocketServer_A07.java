import java.io.*;
import java.net.*;
import java.util.*;

public class java_17935_SocketServer_A07 {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private List<String> clients = new ArrayList<>();

    public static void main(String[] args) {
        new SocketServer().run();
    }

    public void run() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(9999);
            System.out.println("Server started.");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected.");

                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
        } finally {
            if (server != null) {
                server.close();
                System.out.println("Server closed.");
            }
        }
    }

    private class ClientHandler extends Thread {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_17935_SocketServer_A07(Socket client) {
            this.client = client;
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection(client);
                System.out.println("Failed to setup I/O for client: " + e.getMessage());
                return;
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    String[] parts = message.split(" ");
                    if (parts.length != 2 || !USERNAME.equals(parts[0]) || !PASSWORD.equals(parts[1])) {
                        out.println("Invalid username or password");
                    } else {
                        out.println("Authenticated");
                    }

                    out.flush();
                }
            } catch (IOException e) {
                System.out.println("Failed to handle client: " + e.getMessage());
            } finally {
                closeConnection(client);
            }
        }

        private void closeConnection(Socket client) {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    System.out.println("Failed to close client: " + e.getMessage());
                }
            }
        }
    }
}