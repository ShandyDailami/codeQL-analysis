import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27016_SocketServer_A01 {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        while (true) {
            try {
                serverSocket = new ServerSocket(PORT);
                System.out.println("Server started on port: " + PORT);
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());
                handleRequest(socket);
            } catch (IOException e) {
                e.printStackTrace();
                serverSocket.close();
            }
        }
    }

    private static void handleRequest(Socket socket) {
        // Here you can handle the request with security-sensitive operations
    }
}