import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01547_SocketServer_A08 {
    private static final String SERVER_NAME = "SocketServer";
    private static final int PORT = 6000;

    public static void main(String[] args) {
        System.out.println("Starting " + SERVER_NAME + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Perform security-sensitive operations related to A08_IntegrityFailure
                // Here, we'll just log the remote address of the client
                System.out.println("Remote address: " + socket.getInetAddress().getHostAddress());

                // Start a new thread for handling the client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to establish socket server due to " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_01547_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here, we'll read the message from the client
            // We'll just log the received message
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message: " + message);

            // Perform other security-sensitive operations
            // Here, we'll log the received message
            System.out.println("Handled message: " + message);
        } catch (IOException e) {
            System.out.println("Failed to handle client connection due to " + e.getMessage());
        }
    }
}