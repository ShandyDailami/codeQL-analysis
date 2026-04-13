import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10808_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Perform authentication here...
                // If authentication fails, close the connection
                if (!authenticate(socket)) {
                    socket.close();
                    System.out.println("Authentication failed, connection closed");
                } else {
                    // If authentication succeeds, start a new thread for handling the client
                    new ClientHandler(socket).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implement authentication here...
        // For this example, we'll just assume the user is "admin"
        return socket.getRemoteSocketAddress().toString().equals("localhost:4444") && "admin".equals("password");
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_10808_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client's messages here...
            System.out.println("Client's message received");

            // Close the connection
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}