import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10784_SocketServer_A03 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }

    // Inner class to handle each client
    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_10784_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here you could write your code that handles client's requests
                // For example, you could read a message from the client, send a response back, etc.
                // However, this is not related to the injection part and is just a simple demonstration of the server-client communication

                // For now, let's just print the received message
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message: " + message);

                // Send a response back
                String response = "Hello, client!";
                socket.getOutputStream().write(response.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}