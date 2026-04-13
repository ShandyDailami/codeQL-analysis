import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04247_SocketServer_A03 {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"));
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}

class HandleClientThread extends Thread {
    private final Socket socket;

    public java_04247_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // TODO: handle client communication, e.g., read from and write to socket
            // Implement security-sensitive operations here, e.g., prevent SQL injection or XSS attacks

            // Close the client socket after handling
            socket.close();
        } catch (IOException e) {
            System.err.println("Failed to handle client: " + e.getMessage());
        }
    }
}