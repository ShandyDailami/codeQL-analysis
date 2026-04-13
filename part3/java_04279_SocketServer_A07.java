import java.io.*;
import java.net.*;
import java.util.*;

public class java_04279_SocketServer_A07 {

    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        while (true) {
            try {
                Socket client = server.accept();
                System.out.println("Client connected...");
                clients.add(client);

                // Handle client connection in a separate thread
                Handler handler = new Handler(client);
                Thread t = new Thread(handler);
                t.start();
            } catch (IOException e) {
                System.out.println("Error accepting client connection...");
                e.printStackTrace();
            }
        }
    }

    static class Handler implements Runnable {
        private Socket client;

        public java_04279_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Send auth response
                out.writeUTF("Authentication successful");

                // Continuously read and echo messages to the client
                String message;
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received: " + message);
                    for (Socket c : clients) {
                        if (c != client) {
                            DataOutputStream outToClient = new DataOutputStream(c.getOutputStream());
                            outToClient.writeUTF(message);
                        }
                    }
                }

                // Remove client from list and close connection
                clients.remove(client);
                client.close();
            } catch (IOException e) {
                System.out.println("Error handling client connection...");
                e.printStackTrace();
            }
        }
    }
}