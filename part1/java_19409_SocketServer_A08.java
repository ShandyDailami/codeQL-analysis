import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19409_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening for connections: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_19409_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle client communication here.
        // This is just a placeholder. You should implement security-sensitive operations related to A08_IntegrityFailure.
    }
}