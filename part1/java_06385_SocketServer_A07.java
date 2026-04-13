import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_06385_SocketServer_A07 {
    private static final String AUTH_OK = "Authentication successful. Welcome!";
    private static final String AUTH_FAILURE = "Authentication failed. Access denied.";
    private static final String SERVER_MSG = "Hello, client!";

    private static class EchoHandler implements Runnable {
        private Socket socket;

        public java_06385_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Read the username from the client
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String clientMsg = in.readLine();

                // Authenticate the client
                if (clientMsg.equals("username") && checkAuth()) {
                    // Send a welcome message to the client
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(AUTH_OK);
                } else {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(AUTH_FAILURE);
                }
            } catch (IOException e) {
                // Close the connection if an I/O error occurs
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        private boolean checkAuth() {
            // Implement authentication logic here
            // For now, let's just simulate authentication
            return true;
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                // Listen for a connection
                Socket socket = serverSocket.accept();
                // Start a new thread to handle the connection
                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.execute(new EchoHandler(socket));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}