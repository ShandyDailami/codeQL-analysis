import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23180_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create a ServerSocket and wait for incoming connections
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Handle the client connection in a new thread
            new ClientHandler(clientSocket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_23180_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client connection here
            // This is a simplified example, in a real-world application you'd want to handle multiple clients,
            // implement authentication, securely transfer data, handle network errors, etc.

            // Receive a message from the client
            byte[] receivedBytes = new byte[1024];
            int bytesRead = socket.getInputStream().read(receivedBytes);
            String message = new String(receivedBytes, 0, bytesRead);
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Server received your message: " + message;
            socket.getOutputStream().write(response.getBytes());
        }
    }
}