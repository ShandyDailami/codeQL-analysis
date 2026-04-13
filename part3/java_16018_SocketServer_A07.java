import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16018_SocketServer_A07 {
    private static final String PASSWORD = "securePassword"; // Secret password

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444); // Assign port
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = serverSocket.accept(); // Wait for a client to connect
                System.out.println("A client has connected");

                // Start a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ClientHandler class
    static class ClientHandler extends Thread {
        private Socket socket;

        public java_16018_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Get input and output streams
                java.io.BufferedReader in = new java.io.BufferedReader(socket.getInputStream());
                java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true);

                // Read the password from the client
                String password = in.readLine();
                System.out.println("Received password: " + password);

                // Check if the password is correct
                if (password.equals(PASSWORD)) {
                    System.out.println("Password is correct");
                    out.println("Access granted"); // Send a positive message to the client
                } else {
                    System.out.println("Password is incorrect");
                    out.println("Access denied"); // Send a negative message to the client
                }

                socket.close(); // Close the connection
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}