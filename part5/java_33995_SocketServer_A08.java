import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33995_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started. Listening on port 4444");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Start a new thread to handle the client communication
                new ClientHandler(socket).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_33995_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client communication here.
            // This is a simplistic example and doesn't include any security-sensitive operations.
        }
    }
}