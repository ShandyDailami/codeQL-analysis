import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41124_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread for each client
                Thread thread = new ClientHandler(socket);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_41124_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client communication, handle security-sensitive operations, implement A08_IntegrityFailure
        }
    }
}