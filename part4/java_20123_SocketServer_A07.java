import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20123_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted new connection from: " + socket.getRemoteSocketAddress());

                // Perform authentication failure
                // This is a simplistic example where the server simply accepts all connections
                // In a real scenario, you would usually perform authentication here
                // You could also use a more complex method of authentication, such as using certificates or tokens
                if (!authenticate(socket)) {
                    System.out.println("Authentication failure for connection from: " + socket.getRemoteSocketAddress());
                    socket.close();
                } else {
                    System.out.println("Authentication success for connection from: " + socket.getRemoteSocketAddress());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implement authentication here
        // For simplicity, we're just returning true every time
        return true;
    }
}