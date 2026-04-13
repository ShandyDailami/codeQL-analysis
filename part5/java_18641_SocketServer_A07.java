import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18641_SocketServer_A07 {

    private static final String LOCAL_HOST = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Perform authentication here (e.g. using SSL/TLS for secure communication)
                if (authenticateClient(socket)) {
                    handleClientRequests(socket);
                } else {
                    closeConnection(socket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Implement authentication logic here
        // For now, let's assume that the client is authenticated if it's a localhost
        return socket.getInetAddress().getHostAddress().equals(LOCAL_HOST);
    }

    private static void handleClientRequests(Socket socket) {
        // Handle client requests here
        // For now, let's simply say hello to the client
        try (socket.getInputStream(); socket.getOutputStream()) {
            System.out.println("Hello, client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}