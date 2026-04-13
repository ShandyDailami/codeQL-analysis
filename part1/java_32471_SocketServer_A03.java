import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.regex.*;

public class java_32471_SocketServer_A03 {

    private static final String SERVER_NAME = "127.0.0.1";
    private static final int SERVER_PORT = 12345;
    private static final String DATABASE_NAME = "mydatabase";
    private static final String USERNAME = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create server socket
            server = new ServerSocket(SERVER_PORT);
            System.out.println("Server started on port " + SERVER_PORT);

            while (true) {
                // Accept incoming connection
                socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handle client connection in new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // Close server socket
            try {
                if (server != null) server.close();
                if (socket != null) socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_32471_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Get input and output streams
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String inputLine;

                // Read request
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Client says: " + inputLine);

                    // Check if request is SQL injection attack
                    if (isSqlInjectionAttack(inputLine)) {
                        out.println("Attempting SQL Injection attack!");
                        break;
                    }

                    // Continue with normal request processing
                    out.println("Server says: " + inputLine);
                }

                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        private boolean isSqlInjectionAttack(String request) {
            // Pattern to match SQL Injection attempts
            // SQL Injection attempts could be more complex
            // For simplicity, we match exact strings
            return Pattern.matches(".*(?:;|(?:--|#)).*", request);
        }
    }
}