import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07402_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        // Create a server socket and listen for incoming connections
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Accept a new connection
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Handle the new connection in a new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.err.println("Error listening for connections: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // ClientHandler class to handle a single client connection
    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_07402_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Code here is not real security-sensitive because we are not allowing client to connect or send data
            // But it could be used to manage multiple clients and handle multiple connections in a multi-threaded way
        }
    }
}