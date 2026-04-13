import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15798_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");

                // Perform security-sensitive operation (e.g., checking for a specific IP address in the request)
                String request = new String(socket.getInputStream().readNBytes(socket.getInputStream().available()), "UTF-8");
                if (isBrokenRequest(request)) {
                    System.out.println("Broken request detected: " + request);
                    handleBrokenRequest(socket);
                } else {
                    System.out.println("Valid request: " + request);
                    // Handle the request
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isBrokenRequest(String request) {
        // Implement your security-sensitive check here
        // For instance, check if the request contains a specific IP address
        return request.contains("127.0.0.1");
    }

    private static void handleBrokenRequest(Socket socket) {
        // Handle the broken request in a secure manner
        // For instance, deny access or log a warning
        System.out.println("Denying access to client " + socket.getRemoteSocketAddress());
    }
}