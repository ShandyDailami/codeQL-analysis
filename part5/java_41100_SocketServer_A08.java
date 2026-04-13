import java.io.*;
import java.net.*;
import java.util.*;

public class java_41100_SocketServer_A08 {

    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6666);
        System.out.println("Server started...");

        while (true) {
            Socket client = server.accept();
            System.out.println("A new client has connected");

            clients.add(client);

            Thread t = new Thread(new ClientHandler(client));
            t.start();
        }
    }

    static class ClientHandler implements Runnable {

        private Socket client;
        BufferedReader in;
        PrintWriter out;

        public java_41100_SocketServer_A08(Socket client) {
            this.client = client;
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (Exception e) {
                System.out.println("Error handling client " + client);
                close(client);
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Here's where we add the security-sensitive operations for A08_IntegrityFailure
                    // For simplicity, we'll just broadcast the message to all clients
                    for (Socket c : clients) {
                        PrintWriter pw = new PrintWriter(c.getOutputStream(), true);
                        pw.println(message);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error processing client " + client);
                close(client);
            }
        }

        private void close(Socket client) {
            try {
                client.close();
                clients.remove(client);
            } catch (IOException e) {
                System.out.println("Error closing client " + client);
            }
        }
    }
}