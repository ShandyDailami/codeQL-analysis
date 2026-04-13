import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27933_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client is connected from " + clientSocket.getRemoteSocketAddress());

                // Handle client communication in a separate thread
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_27933_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here, for example:
            try {
                // 1. Read from the client
                // 2. Send a response to the client
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}