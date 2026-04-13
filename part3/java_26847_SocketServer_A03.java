import java.io.*;
import java.net.*;
import java.util.*;

public class java_26847_SocketServer_A03 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is running...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());

            clients.add(client);

            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_26847_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // TODO: Implement secure operations, like preventing SQL Injection, XSS, etc.
                    // For simplicity, we just echo back the request
                    out.println(request);
                }

                clients.remove(client);
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}