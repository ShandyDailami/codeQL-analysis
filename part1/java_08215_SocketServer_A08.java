import java.io.*;
import java.net.*;
import java.util.*;

public class java_08215_SocketServer_A08 {
    private static final int PORT = 8080;
    private static Set<Socket> connectedClients = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected: " + client.getRemoteSocketAddress());

            connectedClients.add(client);

            new HandleClient(client).start();
        }
    }

    private static class HandleClient extends Thread {
        Socket client;

        HandleClient(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // handle the message here.
                    // this is a simple example, in real world you might want to check the integrity of the message
                    if (message.equals("FAILURE")) {
                        // change the integrity of the message
                        message = "Success";
                    }

                    // send the message back to the client
                    out.println(message);
                }
            } catch (Exception e) {
                connectedClients.remove(client);
                System.out.println("Client disconnected: " + client.getRemoteSocketAddress());
            }
        }
    }
}