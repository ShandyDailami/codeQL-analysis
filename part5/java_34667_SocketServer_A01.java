import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34667_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        // Bound to port 12345 for the purposes of this example
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform the security-sensitive operation here (e.g., check if the client is authorized, etc.)

                // Start a new thread to handle communication with the client
                new HandleClientThread(socket).start();
            }
        }
    }
}

// A separate thread for each client connection
class HandleClientThread extends Thread {
    private Socket socket;

    public java_34667_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here
        // Perform security-sensitive operations (e.g., decrypt data, etc.)

        // Close the socket when done
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}