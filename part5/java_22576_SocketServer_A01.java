import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22576_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Server failed to start: " + e.getMessage());
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_22576_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Perform security sensitive operations here
                // For example, reading from and writing to the client
                // This is a simplistic example, in a real application you would need to handle
                // all possible exceptions and also check for the client's identity to ensure it's not being targeted
                // with malicious requests

                // Get input and output streams
                var in = clientSocket.getInputStream();
                var out = clientSocket.getOutputStream();

                // Read a message from the client
                var msg = in.readUTF();
                System.out.println("Received: " + msg);

                // Send a response back to the client
                out.writeUTF("Hello, client!");
                out.flush();

                // Close the connection
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            }
        }
    }
}