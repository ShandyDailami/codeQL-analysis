import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37593_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getInetAddress().getHostAddress() + " connected");

                // Create a new thread for each client connection
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + PORT);
            System.exit(-1);
        }
    }

    // Inner class to handle client connections
    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_37593_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Perform security-sensitive operations here
                // For example, reading from and writing to the socket
                // You can use the socket to send a message to the client
                // However, be aware that this is a simplified example and real-world
                // implementations would be much more complex
                String message = socket.getInputStream().readUTF();
                System.out.println("Received: " + message);

                // Send a response back to the client
                socket.getOutputStream().writeUTF("Message received");
            } catch (IOException e) {
                System.err.println("Error handling client " + socket.getInetAddress().getHostAddress());
            }
        }
    }
}