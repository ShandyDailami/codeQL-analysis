import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24298_SocketServer_A07 {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started!");

            while (true) {
                // Wait for a client to connect
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Create a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_24298_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Get the input and output streams
            try {
                java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true);
                java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));

                // Read the username and password
                String username = in.readLine();
                String password = in.readLine();

                // Check if the username and password match
                if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                    out.println("Authentication successful!");
                } else {
                    out.println("Authentication failed!");
                }

                // Close the connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}