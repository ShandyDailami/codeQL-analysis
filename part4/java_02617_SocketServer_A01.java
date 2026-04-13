import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02617_SocketServer_A01 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Here you can add a security check to ensure the client has requested a secure connection
            // For the purpose of this example, we'll just accept all connections

            new ClientHandler(clientSocket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_02617_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Here you can add the code to handle the client's requests
            // This will depend on what your application does
        }
    }
}