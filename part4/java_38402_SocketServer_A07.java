import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_38402_SocketServer_A07 {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = null;
            // Check if we are using port 8000 or 443 (HTTPS)
            if (args.length == 0 || (!"-ssl".equals(args[0]) && args[0].matches("^[0-9]+$"))) {
                serverSocket = new ServerSocket(8000);
            } else {
                serverSocket = new SSLServerSocket(8000);
            }

            while (true) {
                // Accept a client socket
                Socket socket = serverSocket.accept();

                // Accept an SSL socket
                if (serverSocket instanceof SSLServerSocket) {
                    try (SSLSocket sslSocket = (SSLSocket) socket) {
                        sslSocket.handshake();
                    }
                }

                // Authenticate the user
                String clientUsername = socket.getRemoteSocketAddress().toString();
                if (!clientUsername.equals(USERNAME) || !PASSWORD.equals(socket.getInputStream().readUTF())) {
                    System.out.println("Authentication failed.");
                    socket.close();
                    continue;
                }

                // Process the client
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}