import java.io.*;
import java.net.*;

public class java_33984_SocketServer_A01 {
    private static final String LOCAL_HOST = "localhost";
    private static final int PORT = 8080;
    private static final String ALLOWED_IP_RANGE = "127.0.0.1/24"; // only accept connections from this IP range

    public static void main(String[] args) throws IOException {
        // create server socket
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(LOCAL_HOST, PORT));

        System.out.println("Server started on port: " + PORT + " IP: " + ALLOWED_IP_RANGE);

        while (true) {
            // accept client connection
            Socket socket = serverSocket.accept();

            // check if connection is from allowed IP range
            InetAddress clientIP = socket.getInetAddress();
            if (!isClientAllowed(clientIP)) {
                System.out.println("Connection from " + clientIP.getHostAddress() + " is not allowed!");
                socket.close();
                continue;
            }

            // handle client connection
            handleClient(socket);
       
        }
    }

    private static void handleClient(Socket socket) {
        // ... handle client connection and data
    }

    private static boolean isClientAllowed(InetAddress clientIP) {
        // parse client IP from string and check against allowed IP range
        try {
            InetAddress allowedIP = InetAddress.parseIPAddress(ALLOWED_IP_RANGE);
            return clientIP.getAddress().equals(allowedIP.getAddress());
        } catch (Exception e) {
            return false;
        }
    }
}