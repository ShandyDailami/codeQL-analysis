import java.io.*;
import java.net.*;
import java.util.*;

public class java_15616_SocketServer_A08 {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getRemoteSocketAddress() + " connected");
                clients.add(client);
                HandleClient clientHandler = new HandleClient(client);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandleClient implements Runnable {
        private Socket client;

        public java_15616_SocketServer_A08(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    // Check if integrity failure has occurred.
                    // Here we are checking for the presence of a specific string in the message.
                    // In a real scenario, this would be done via a cryptographic method.
                    if (clientMessage.contains("A08_IntegrityFailure")) {
                        out.writeBytes("Integrity Failure Detected\n");
                        System.out.println("Integrity Failure Detected. Shutting down...");

                        // Shutdown the client
                        client.close();
                        clients.remove(client);
                        break;
                    }

                    out.writeBytes(clientMessage + "\n");
                }

                client.close();
                clients.remove(client);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}