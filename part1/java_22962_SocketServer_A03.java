import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22962_SocketServer_A03 {

    private static final String PASSWORD = "securepassword";
    private static final String ALLOWED_IP = "127.0.0.1";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Authenticate the client
                String clientIP = socket.getRemoteSocketAddress().toString();
                if (!clientIP.equals(ALLOWED_IP) || !authenticate(socket)) {
                    System.out.println("Authentication failed. Closing connection.");
                    socket.close();
                    continue;
                }

                // Handle the request
                handleRequest(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        try {
            // Simulate an authentication process by reading the password from the socket
            return PASSWORD.equals(readPassword(socket));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String readPassword(Socket socket) throws IOException {
        byte[] buffer = new byte[4];
        socket.getInputStream().read(buffer);
        return new String(buffer, "UTF-8");
    }

    private static void handleRequest(Socket socket) {
        try {
            // Simulate a request handling process by reading a message from the socket
            byte[] buffer = new byte[4];
            socket.getInputStream().read(buffer);
            String message = new String(buffer, "UTF-8");
            System.out.println("Received message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}