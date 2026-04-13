import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08220_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Here you would normally handle the socket for a specific task,
                // but in this case, we're not doing anything with it, so we're just closing it.
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening for connections: " + e.getMessage());
        }
    }
}