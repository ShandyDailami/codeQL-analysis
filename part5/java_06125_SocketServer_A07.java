import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06125_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Here you would want to add your own authentication logic
                // For the sake of this example, we'll just assume that every client is authenticated
                if (!authenticateClient(socket)) {
                    System.out.println("Client failed to authenticate");
                    socket.close();
                } else {
                    System.out.println("Client successfully authenticated");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Add your own authentication logic here
        // For the sake of this example, we'll just assume that the client's IP address is valid
        String clientIP = socket.getInetAddress().getHostAddress();
        return validateIP(clientIP);
    }

    // This is a simple IP validation, it's not recommended to use in a real security application
    private static boolean validateIP(String ip) {
        // Add your own validation logic here
        // For the sake of this example, we'll just assume that all IPs are valid
        return true;
    }
}