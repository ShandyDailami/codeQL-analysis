import java.io.*;
import java.net.*;
import java.util.*;

public class java_04933_SocketServer_A07 {
    private static final int PORT = 1234;
    private static Set<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");

                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                clients.add(out);

                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection");
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public java_04933_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException ex) {
                closeConnection();
            }
        }

        public void run() {
            try {
                String message, response;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Perform some security sensitive operation here, for example:
                    // Authenticate the client with server (e.g., check for a username and password)
                    // If authentication fails, send an authentication failure message to the client
                    // If authentication succeeds, send a welcome message to the client
                    // Proceed with other security sensitive operations
                    response = "Server: Hello, client!";
                    out.println(response);
                    out.flush();
                }
            } catch (IOException ex) {
                closeConnection();
            }
        }

        private void closeConnection() {
            // Close the client connection and remove the client from the set of clients
            clients.remove(out);
            try {
                out.close();
                in.close();
                clientSocket.close();
            } catch (IOException ex) {
                // Ignore exceptions
            }
            System.out.println("Client disconnected");
        }
    }
}