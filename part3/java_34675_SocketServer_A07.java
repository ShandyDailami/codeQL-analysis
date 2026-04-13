import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_34675_SocketServer_A07 {
    public static void main(String[] args) {
        // Start a new thread for the server
        new ServerThread().start();
    }

    // Create a new thread to handle client requests
    public static class ServerThread extends Thread {
        @Override
        public void run() {
            try {
                // Wait for client connection
                Socket socket = Main.server.accept();

                // Create input and output stream
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Print a welcome message
                out.println("Welcome!");

                // Handle each request from the client
                String request;
                while ((request = in.readLine()) != null) {
                    out.println("Echo: " + request);

                    // Check for auth failure
                    if (request.equals("AuthFailure")) {
                        out.println("Auth failure!");
                    }
                }

                // Close connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Main server
    public static class Main {
        private static final int PORT = 8080;

        static java.net.ServerSocket server;

        public static void main(String[] args) {
            try {
                // Initialize server
                server = new java.net.ServerSocket(PORT);
                System.out.println("Server started on port " + PORT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}