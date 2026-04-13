import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00274_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client communication
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_00274_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle client communication here. This is a placeholder.
        // You should not attempt to read or write data until you've set up a socket stream.
    }
}