import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13464_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_13464_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Receive message from client
                byte[] bytes = new byte[1024];
                socket.getInputStream().read(bytes);

                // XOR encryption
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] ^= 0xAA;
                }

                // Send back to client
                socket.getOutputStream().write(bytes);

            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            }
        }
    }
}