import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06551_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create a new ServerSocket and wait for client connections
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        // Wait for client connections
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Start a new thread to handle this client
            new ClientHandler(socket).start();
        }
    }

    // Handles communication with a client
    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_06551_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: handle client communication
        }
    }
}