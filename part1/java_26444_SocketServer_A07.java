import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26444_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                new Thread(() -> {
                    try {
                        // Receive request
                        byte[] bytes = new byte[1024];
                        socket.getInputStream().read(bytes);
                        String request = new String(bytes);
                        System.out.println("Received: " + request);

                        // Send response
                        String response = "Hello, client!";
                        socket.getOutputStream().write(response.getBytes());
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