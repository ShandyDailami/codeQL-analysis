import java.io.*;
import java.net.*;
import java.util.*;

public class java_28369_SocketServer_A03 {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234...");

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected!");

                clients.add(client);

                // Start a new thread to handle communication with the client
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_28369_SocketServer_A03(Socket client) {
            this.client = client;

            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                // Handle the message here
                // For example, echo the message back to the client
                sendMessage("Echo: " + message);
            }

            // Remove the client from the list
            clients.remove(client);
            client.close();
        }

        private String readMessage() {
            String message = null;
            try {
                message = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return message;
        }

        private void sendMessage(String message) {
            out.println(message);
        }
    }
}