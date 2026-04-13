import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class java_11085_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Create a new thread for handling the client request
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_11085_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // TODO: handle the request
                // This is a placeholder for your code. Replace with your actual implementation.
                // Example: read a request from the client, handle it, send a response back, etc.
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}