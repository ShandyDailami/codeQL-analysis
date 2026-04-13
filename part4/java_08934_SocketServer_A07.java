import java.io.*;
import java.net.*;
import java.util.*;

public class java_08934_SocketServer_A07 {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Waiting for client on port 8189...");

            while (true) {
                Socket client = server.accept();
                clients.add(client);
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Handling client thread
                new EchoThread(client).start();
            }
        } catch (IOException ex) {
            System.out.println("IOException in server: " + ex.getMessage());
        }
    }

    // Thread for handling one client
    private static class EchoThread extends Thread {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_08934_SocketServer_A07(Socket client) {
            this.client = client;
            try {
                in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException ex) {
                System.out.println("IOException in EchoThread: " + ex.getMessage());
                closeConnection();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Echo back the message
                    out.println(message);
                }
            } catch (IOException ex) {
                System.out.println("IOException in run: " + ex.getMessage());
                closeConnection();
            }
        }

        private void closeConnection() {
            clients.remove(client);
            try {
                client.close();
            } catch (IOException ex) {
                System.out.println("IOException in closeConnection: " + ex.getMessage());
            }
            System.out.println("Client disconnected.");
        }
    }
}