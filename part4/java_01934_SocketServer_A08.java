import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01934_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Start a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server failed to start. Port might be already in use.");
            e.printStackTrace();
        }
    }

    // A thread to handle each client connection
    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_01934_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Implement your security-sensitive operations here

            // TODO: Add code here to handle the client socket
            // ...
        }
    }
}