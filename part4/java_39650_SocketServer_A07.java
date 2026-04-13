import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39650_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT + "...");

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Perform security-sensitive operations like authentication
                // You can use a library like Bouncy Castle for Java for stronger security measures
                // If authentication fails, you can send a response to the client

                // For the purpose of this example, let's simulate a successful authentication
                if (authenticate(clientSocket)) {
                    new Thread(new ClientHandler(clientSocket)).start();
                } else {
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implement your authentication logic here
        // This is a placeholder, replace with your actual authentication logic
        return true;
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_39650_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Handle client messages here
                // This is a placeholder, replace with your actual client message handling
                String message = clientSocket.getInputStream().readUTF();
                System.out.println("Received: " + message);

                clientSocket.getOutputStream().writeUTF("Hello, Client!");
                clientSocket.getOutputStream().flush();

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}