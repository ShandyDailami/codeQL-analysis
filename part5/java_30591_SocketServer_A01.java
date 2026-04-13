import java.io.*;
import java.net.*;
import java.util.*;

public class java_30591_SocketServer_A01 {

    private static List<Socket> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket client = server.accept();
            clients.add(client);
            System.out.println("Client accepted from " + client.getRemoteSocketAddress());

            // Spawn a new thread for the client
            new ClientHandler(client).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_30591_SocketServer_A01(Socket client) {
            this.client = client;
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException e) {
                clients.remove(client);
                client.close();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Process the message here, for example, broadcast it to all other clients
                    for (Socket sock : clients) {
                        PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
                        pw.println(message);
                    }
                }
            } catch (IOException e) {
                clients.remove(client);
                client.close();
            }
        }
    }
}