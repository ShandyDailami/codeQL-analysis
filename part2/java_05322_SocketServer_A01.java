import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05322_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                new Thread(() -> {
                    try {
                        // Read from client
                        byte[] buffer = new byte[1024];
                        int bytesRead = socket.getInputStream().read(buffer);
                        String message = new String(buffer, 0, bytesRead);

                        // Print received message
                        System.out.println("Received: " + message);

                        // Close connection
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}