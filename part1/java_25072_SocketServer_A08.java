import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25072_SocketServer_A08 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                new Thread(() -> {
                    try {
                        // read incoming message from client
                        byte[] bytes = new byte[1024];
                        socket.getInputStream().read(bytes);
                        String message = new String(bytes);
                        System.out.println("Received: " + message);

                        // close connection
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