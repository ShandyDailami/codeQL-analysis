import java.io.*;
import java.net.*;
import java.util.*;

public class java_02515_SocketServer_A01 {
    private static final String SERVER_SOCKET_ADDRESS = "localhost";
    private static final int SERVER_SOCKET_PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Create a server socket
            serverSocket = new ServerSocket(SERVER_SOCKET_PORT);

            System.out.println("Server started on port: " + SERVER_SOCKET_PORT);

            while (true) {
                // Wait for client connection
                Socket clientSocket = serverSocket.accept();

                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create a new thread for handling client
                Thread clientHandler = new Thread(new ClientHandler(clientSocket));

                // Start the thread
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_02515_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    // Replace specific user input with hardcoded values
                    String serverMessage = "Server: Hello, client!";

                    // Send the message back to the client
                    out.println(serverMessage);
                }

                // Close the connection
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}