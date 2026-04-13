import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39131_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to listen for connection on port " + PORT);
            System.exit(-1);
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_39131_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Here you can add your security-sensitive operations related to A08_IntegrityFailure
                // For example, you can add code to verify the integrity of the client's data,
                // or handle the client's socket exceptions.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}