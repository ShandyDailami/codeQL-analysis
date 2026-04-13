import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_06927_SocketServer_A07 {

    private final List<String> authorizedUsers = Arrays.asList("John", "Mike", "Sara", "Alice");
    private boolean isAuthorized(String username) {
        return authorizedUsers.contains(username);
    }

    public void startServer(int port) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(port);
            while (true) {
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                InetAddress clientAddress = socket.getInetAddress();
                System.out.println("Client " + clientAddress.getHostAddress() + " is connected");

                if (!isAuthorized(socket.getRemoteSocketAddress().getHostName())) {
                    System.out.println("Access denied for " + clientAddress.getHostAddress());
                    socket.close();
                    continue;
                }

                // Handle client connection here
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 8080;
        SecureSocketServer server = new SecureSocketServer();
        server.startServer(port);
    }
}