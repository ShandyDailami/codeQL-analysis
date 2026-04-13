import java.io.*;
import java.net.*;
import java.util.*;

public class java_01206_SocketServer_A01 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 9999;
    private static final int MAX_CONNECTIONS = 5;

    private static List<Socket> clientSockets = Collections.synchronizedList(new ArrayList<Socket>());

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT, MAX_CONNECTIONS);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientSockets.add(clientSocket);

                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Start a new thread to handle communication with the client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_01206_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;

            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        public void run() {
            try {
                // Read the client's request
                String request = in.readLine();
                System.out.println("Received request: " + request);

                // Handle the request (e.g., authenticate the client, send a response)
                if (authenticateClient(request)) {
                    out.println("Access granted");
                } else {
                    out.println("Access denied");
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private boolean authenticateClient(String request) {
            // Implement the client authentication logic here
            // For the purpose of this example, we just check if the request is empty
            return !request.isEmpty();
        }

        private void closeConnection() {
            // Remove the client from the list of active clients
            clientSockets.remove(clientSocket);

            // Close the client's sockets
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Client connection closed");
        }
    }
}