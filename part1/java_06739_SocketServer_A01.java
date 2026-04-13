import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06739_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start: " + e.getMessage());
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;

        public java_06739_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Access control: only allow secure connections
            if (socket.getLocalSocketAddress().equals(socket.getRemoteSocketAddress())) {
                // TODO: handle secure communication with client
            } else {
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
    }
}