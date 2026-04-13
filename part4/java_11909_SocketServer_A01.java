import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11909_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                new Handler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}

class Handler extends Thread {
    private final Socket socket;

    public java_11909_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can put the code related to the security-sensitive operations
            // Like checking for broken access controls, implementing encryption/decryption, etc.

            // Example of secure operation:
            // socket.getInputStream().read(); // BrokenAccessControl, here we are reading from the socket
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}