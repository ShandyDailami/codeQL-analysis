import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02986_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Perform the necessary security-sensitive operations here.
                // For the sake of this example, we'll just print a message.
                // In a real scenario, you would likely use authentication and authorization methods.
                new Thread(() -> {
                    try {
                        String message = socket.getInputStream().readUTF();
                        System.out.println("Received: " + message);
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