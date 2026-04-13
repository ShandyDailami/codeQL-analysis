import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41165_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected!");

                // Perform security-sensitive operations here
                // For example, use SSL/TLS for secure communication

                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Server could not listen on port " + PORT);
            System.exit(-1);
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_41165_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Perform operations on the client here
            // For example, use SSL/TLS for secure communication
        }
    }
}