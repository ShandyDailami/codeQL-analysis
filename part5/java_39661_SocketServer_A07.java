import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39661_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here, we are assuming that the client is authenticated.
                // This is a placeholder and should not be used in real applications.
                if (authenticateClient(socket)) {
                    handleRequest(socket);
                } else {
                    closeConnection(socket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Implementation of client authentication here
        // This is a placeholder and should not be used in real applications.
        return true;
    }

    private static void handleRequest(Socket socket) {
        // Handle the request here
        // This is a placeholder and should not be used in real applications.
    }

    private static void closeConnection(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}