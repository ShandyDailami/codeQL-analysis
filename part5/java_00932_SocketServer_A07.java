import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class java_00932_SocketServer_A07 {
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Your authentication process goes here
                // For simplicity, we'll just check if the socket is authenticated
                if (authenticate(socket)) {
                    new Thread(new ClientHandler(socket)).start();
                } else {
                    System.out.println("Authentication failed for " + socket.getRemoteSocketAddress());
                    socket.close();
                }
            }
        } catch (IOException e) {
            System.err.println("Error occurred while processing requests: " + e.getMessage());
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implementation of authentication process. For the sake of simplicity, we'll return true for all sockets
        return true;
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_00932_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here
        }
    }
}