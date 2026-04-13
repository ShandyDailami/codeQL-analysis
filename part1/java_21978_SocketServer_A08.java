import java.io.*;
import java.net.*;

public class java_21978_SocketServer_A08 {
    private static final String SERVER_SOCKET_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        // Initialize server socket
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is running on port: " + SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        while (true) {
            try {
                // Accept a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getRemoteSocketAddress());

                // Create a new thread to handle the client request
                new ClientHandler(clientSocket).start();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    static class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_21978_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
                closeConnection();
            }
        }

        public void run() {
            try {
                // Receive a message from the client
                String message = in.readLine();
                System.out.println("Received: " + message);

                // Send a response to the client
                out.println("Hello, client!");

                // Check for integrity failure (e.g., message was tampered with)
                if (message.equals("A08_IntegrityFailure")) {
                    out.println("Integrity failure detected!");
                    closeConnection();
                } else {
                    out.println("Integrity check passed!");
                }
            } catch (IOException e) {
                e.printStackTrace();
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}