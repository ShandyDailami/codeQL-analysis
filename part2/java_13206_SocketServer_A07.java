import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13206_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication successful!";
    private static final String AUTHENTICATION_FAILURE = "Authentication failed!";
    private boolean authSuccess = false;

    public void startServer(int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getInetAddress().getHostAddress());
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Server couldn't start: " + e.getMessage());
       
        }
    }

    private class ClientHandler extends Thread {
        private Socket client;

        public java_13206_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Here you could perform more complex operations related to security
                // For this example, we'll simulate a simple authentication
                authSuccess = simulateAuthentication();
                if (authSuccess) {
                    client.getOutputStream().write(AUTHENTICATION_SUCCESS.getBytes());
                } else {
                    client.getOutputStream().write(AUTHENTICATION_FAILURE.getBytes());
                }
            } catch (IOException e) {
                System.out.println("Client handling failed: " + e.getMessage());
            }
        }

        private boolean simulateAuthentication() {
            // You'd typically connect to a database or some other source of authentication here
            // For this example, we'll just return a static value
            return true;
        }
    }

    public static void main(String[] args) {
        new SocketServer().startServer(8080);
    }
}