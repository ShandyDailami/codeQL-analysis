import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class java_04953_SocketServer_A07 {

    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is running on port: " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Perform authentication here with the client
                if (authenticateClient(socket)) {
                    handleClient(socket);
                } else {
                    closeSocket(socket);
                    System.out.println("Authentication failed for client: " + socket.getRemoteSocketAddress());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Implement authentication logic here
        // For simplicity, we'll just return true
        return true;
    }

    private static void handleClient(Socket socket) {
        // Implement client handling logic here
    }

    private static void closeSocket(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}