import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26224_SocketServer_A01 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                new HandleClient(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }

    private static class HandleClient extends Thread {
        private final Socket socket;

        public java_26224_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here you can add your code to handle the client connection,
                // such as reading from and writing to the socket,
                // but note that this is a simplistic example and might not be secure.
                // In a real application, you would need to handle authentication,
                // encryption, and other security-sensitive operations.
            } catch (IOException e) {
                System.out.println("Error handling client connection: " + e.getMessage());
            }
        }
    }
}