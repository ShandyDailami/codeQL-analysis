import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class java_11498_SocketServer_A08 {
    private static final Set<String> whitelist = new HashSet<>();

    static {
        // Add IP addresses to the whitelist
        // Example: whitelist.add("192.168.0.1");
    }

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            while (true) {
                try (Socket socket = server.accept()) {
                    String clientAddress = socket.getInetAddress().getHostAddress();

                    if (whitelist.contains(clientAddress)) {
                        System.out.println("Accepted connection from: " + clientAddress);
                        // Handle the connection here
                    } else {
                        System.out.println("Connection from " + clientAddress + " is not whitelisted");
                        socket.close();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }
}