import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38761_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication Successful";
    private static final String AUTHENTICATION_FAILURE = "Authentication Failed";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            while (true) {
                Socket socket = server.accept();
                handleRequest(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        // Simulate authentication process
        boolean isAuthenticated = authenticateUser(socket.getRemoteSocketAddress().toString());

        if (isAuthenticated) {
            response(socket, AUTHENTICATION_SUCCESS);
        } else {
            response(socket, AUTHENTICATION_FAILURE);
        }
    }

    private static boolean authenticateUser(String ipAddress) {
        // Implement user authentication logic here, for simplicity, we just check if the ip address is authorized
        return isAuthorizedIpAddress(ipAddress);
    }

    private static void response(Socket socket, String message) {
        try {
            socket.getOutputStream().write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAuthorizedIpAddress(String ipAddress) {
        // Add your own logic for authorization
        // This is just for demonstration
        return ipAddress.equals("127.0.0.1") || ipAddress.equals("192.168.1.1");
    }
}