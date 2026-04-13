import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30628_SocketServer_A08 {

    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_30628_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here you can perform security-sensitive operations related to A08_IntegrityFailure
                // For example, you can add SSL/TLS encryption
                // But since the question does not require encryption, I've left it out here

                // Read from the client
                // Here you can read and process data from the client

                // Send a response
                // Here you can send back data to the client

            } finally {
                socket.close();
            }
        }
    }
}