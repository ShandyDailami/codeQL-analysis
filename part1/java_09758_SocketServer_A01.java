import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09758_SocketServer_A01 {
    private final int port;
    private boolean isStopped = false;

    public java_09758_SocketServer_A01(int port) {
        this.port = port;
    }

    public void stopServer() {
        isStopped = true;
    }

    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port " + port);
            while (!isStopped) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted new client from " + socket.getRemoteSocketAddress());

                // Perform basic authentication
                String username = socket.getRemoteSocketAddress().toString();
                String password = "secret";
                if (!authenticate(username, password)) {
                    System.out.println("Authentication failed for " + socket.getRemoteSocketAddress());
                    continue;
                }

                // Handle connection
                new SocketHandler(socket).start();
            }
            System.out.println("Server stopped.");
        } catch (IOException e) {
            if (!isStopped) System.err.println("Error in socket server: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean authenticate(String username, String password) {
        // In a real-world application, you'd likely want to use a more secure method
        // of authenticating users, such as hashing the password and comparing it to a stored hash.
        // This is a simple example and assumes you're just using a hardcoded password.
        return username.equals("admin") && password.equals("secret");
    }

    private class SocketHandler extends Thread {
        private final Socket socket;

        public java_09758_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Handle client connection and communication...
        }
    }
}