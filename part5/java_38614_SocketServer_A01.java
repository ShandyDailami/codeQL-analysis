import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38614_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error in server listening: " + e.getMessage());
       
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_38614_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Here you can add code for security-sensitive operations
                // For example, you can read and send data in a secure manner
                // but for the purpose of this example, we just echo back the data
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = clientSocket.getInputStream().read(buffer)) != -1) {
                    clientSocket.getOutputStream().write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                System.out.println("Error in handling client connection: " + e.getMessage());
            }
        }
    }
}