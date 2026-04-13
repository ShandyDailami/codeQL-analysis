import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27587_SocketServer_A01 {

    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Perform security-related operations such as:
                // 1. Bypassing the check for access control
                // 2. Preventing unauthorized access to the server
                // 3. Implementing encryption to secure data
                // 4. Implementing authentication and authorization

                // Here is a simple code snippet to demonstrate the above operations
                new Thread(() -> {
                    try {
                        // TODO: Implement the above operations
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