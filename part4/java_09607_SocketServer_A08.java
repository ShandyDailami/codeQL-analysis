import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09607_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations related to A08_IntegrityFailure here
                // For example, create a new thread for each connected client
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        // If an IOException occurs, we need to close the ServerSocket
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_09607_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client communication here
            // For example, read from the client and print received data
        }
    }
}