import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40401_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started, waiting for connections on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle communication with the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_40401_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Perform necessary security operations related to A01_BrokenAccessControl here

                // Get input and output streams
                java.io.DataInputStream in = new java.io.DataInputStream(socket.getInputStream());
                java.io.DataOutputStream out = new java.io.DataOutputStream(socket.getOutputStream());

                // Read a message from the client
                String message = in.readUTF();
                System.out.println("Received message: " + message);

                // Send a response back to the client
                out.writeUTF("Hello, client!");
                out.flush();
            } catch (IOException e) {
                System.err.println("Failed to handle client: " + e.getMessage());
            }
        }
    }
}