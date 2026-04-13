import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34841_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here, we're using a simple check for integrity failure
                // This is a placeholder and not a real-world security check
                // Replace with real-world check
                if (socket.getInputStream().read() != socket.getOutputStream().write(1)) {
                    System.out.println("Integrity failure detected, closing connection");
                    socket.close();
                } else {
                    System.out.println("No integrity failure detected");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}