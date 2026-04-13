import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.*;

public class java_17352_SocketServer_A03 {

    private static final int PORT = 5000;
    private static ExecutorService executor;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted from " + socket.getRemoteSocketAddress());
                authenticateClient(socket);
            }
        } catch (IOException e) {
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

    private static void authenticateClient(Socket socket) {
        executor.submit(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_17352_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Check if client is authenticated
                    if (isClientAuthenticated(message)) {
                        out.println("Successfully authenticated");
                    } else {
                        out.println("Authentication failed");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isClientAuthenticated(String message) {
            // This is a simple example of authentication. Real-world applications would use more complex methods.
            // The authentication can be done by comparing hashes of the input message with pre-calculated hashes.
            return true;
        }
    }
}