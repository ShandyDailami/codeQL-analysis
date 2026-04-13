import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23458_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start the server due to: " + e.getMessage());
        }
    }
}

class SocketHandler implements Runnable {
    private final Socket socket;

    public java_23458_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Write your code here to handle the socket operations.
            // For example:
            // socket.getInputStream().read();
            // socket.getOutputStream().write();
        } catch (IOException e) {
            System.out.println("Failed to handle the socket due to: " + e.getMessage());
        }
    }
}