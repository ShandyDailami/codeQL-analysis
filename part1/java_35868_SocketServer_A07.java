import java.net.*;
import java.io.*;

public class java_35868_SocketServer_A07 {

    // Our server socket.
    private ServerSocket serverSocket;

    // Our main method.
    public static void main(String[] args) {
        new SecureSocketServer().startServer();
    }

    // Start the server.
    public void startServer() {
        try {
            // Create a new server socket on a port.
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            while (true) {
                // Wait for a client to connect.
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for this client.
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port 4444. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    // A thread that handles a single client connection.
    class ClientHandler extends Thread {
        private Socket clientSocket;

        public java_35868_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                // Create a new buffered reader and writer.
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read the client's username.
                String username = reader.readLine();
                System.out.println("Username: " + username);

                // Read the client's password.
                String password = reader.readLine();
                System.out.println("Password: " + password);

                // Authenticate the client.
                if (authenticate(username, password)) {
                    // If the authentication is successful, send a welcome message.
                    writer.println("Welcome, you are now authenticated!");
                } else {
                    // If the authentication is not successful, send an error message.
                    writer.println("Error: Authentication failed!");
                }

                // Close the reader and writer.
                reader.close();
                writer.close();
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Failed to communicate with client. Exiting...");
                e.printStackTrace();
                System.exit(-1);
            }
        }

        // Authenticate the client.
        private boolean authenticate(String username, String password) {
            // Here you should implement your own authentication logic.
            // For simplicity, we just check if the username is "admin" and the password is "password".
            return "admin".equals(username) && "password".equals(password);
        }
    }
}