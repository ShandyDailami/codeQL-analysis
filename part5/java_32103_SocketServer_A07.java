import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32103_SocketServer_A07 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handling the client's request in a secure manner.
                // This is a simplistic example and doesn't include real-world security measures.
                // In a real-world scenario, you'd want to use real authentication and authorization mechanisms.
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_32103_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client's request in a secure manner.
        // This is a simplistic example and doesn't include real-world security measures.
        // In a real-world scenario, you'd want to use real authentication and authorization mechanisms.
        try {
            // Read and process the request from the client
            // ...

            // Send a response back to the client
            // ...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}