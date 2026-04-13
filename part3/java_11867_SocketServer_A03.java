import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11867_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Perform the requested operations here
                // For example, handle each message received from the client separately

                // Here is a simple way to simulate injection:
                // You can replace the following line with code that manipulates the socket
                socket.getInputStream().read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}