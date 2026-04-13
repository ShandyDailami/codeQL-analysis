import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35323_SocketServer_A01 {

    private final static int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here you can add your security-sensitive operations
                // For example, you can create a new Thread to handle the communication with the client
                new Thread(() -> {
                    handleRequest(socket);
                    socket.close();
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        // Implementation of the handleRequest method
    }
}