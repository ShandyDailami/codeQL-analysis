import java.io.*;
import java.net.*;
import java.util.*;

public class java_16327_SocketServer_A07 {

    // The server will listen on this port
    private static final int PORT = 12345;

    // List of active clients
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(PORT)) {

            while (true) {
                System.out.println("Waiting for client connection...");

                // Accept the client connection
                Socket clientSocket = server.accept();
                System.out.println("Client connected!");

                // Add the client to the list of active clients
                clients.add(clientSocket);

                // Start a new thread to handle communication with the client
                new ClientHandler(clientSocket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Thread for handling client communication
    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_16327_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;

            try {
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                // Read the client's message
                String message = in.readLine();
                System.out.println("Client message: " + message);

                // Check if the client is authenticated
                if (message.equals("authenticated")) {
                    // If so, send a response
                    out.println("authenticated");
                } else {
                    // If not, send a failure
                    out.println("failed");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}