import java.io.*;
import java.net.*;
import java.util.*;

public class java_19883_SocketServer_A08 {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(12345);
            System.out.println("Server started at " + new Date());
            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getInetAddress().getHostAddress() + " connected at " + new Date());
                clients.add(client);
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client at " + new Date());
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

    private static class ClientHandler extends Thread {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_19883_SocketServer_A08(Socket client) {
            this.client = client;
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException e) {
                close();
                return;
            }
        }

        public void run() {
            try {
                out.println("Welcome to the server!");
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received message from " + client.getInetAddress().getHostAddress() + ": " + message);
                    // TODO: Add your security-sensitive operations related to A08_IntegrityFailure here
                    // For example, check if the message is valid
                    // If not valid, respond with an error message
                    // If valid, handle the message in a way that is secure
                }
            } catch (IOException e) {
                close();
                return;
            }
        }

        private void close() {
            clients.remove(client);
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}