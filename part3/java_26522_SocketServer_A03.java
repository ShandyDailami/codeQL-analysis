import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26522_SocketServer_A03 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_26522_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Receive message from client, handle it, and send a response back
            // Here, we'll just echo the message, but in a real-world application,
            // you'd probably want to verify and sanitize the message before echoing it
            try {
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String message = new String(buffer);
                System.out.println("Received: " + message);

                // Echo the message back to the client
                socket.getOutputStream().write(message.getBytes());
                socket.getOutputStream().flush();
            } catch (IOException e) {
                System.out.println("Error handling client connection: " + e.getMessage());
            }
        }
    }
}