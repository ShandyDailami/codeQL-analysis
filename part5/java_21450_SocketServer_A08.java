import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21450_SocketServer_A08 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection " + e.getMessage());
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_21450_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Perform security-sensitive operations related to A08_IntegrityFailure
        try {
            // Perform operations here
        } catch (Exception e) {
            System.out.println("Error handling client " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error closing socket " + e.getMessage());
            }
        }
    }
}