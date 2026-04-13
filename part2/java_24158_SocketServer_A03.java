import java.io.*;
import java.net.*;
import java.util.*;

public class java_24158_SocketServer_A03 {
    private static final int PORT = 12345;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());
            clients.add(client);

            new HandleClient(client).start();
        }
    }

    private static class HandleClient extends Thread {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_24158_SocketServer_A03(Socket client) {
            this.client = client;
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
                clients.remove(client);
                closeConnection();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // This is where you would perform injection attacks. 
                    // The following is just a placeholder for demonstration purposes.
                    String response = "Server received: " + message;
                    for (Socket sock : clients) {
                        PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
                        pw.println(response);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading from client: " + e.getMessage());
                closeConnection();
            }
        }

        private void closeConnection() {
            clients.remove(client);
            try {
                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}