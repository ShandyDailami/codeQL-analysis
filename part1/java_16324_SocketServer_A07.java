import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_16324_SocketServer_A07 {

    private static final String SSL_PORT = "11111";
    private static final String NON_SSL_PORT = "22222";

    public static void main(String[] args) {
        int port = Integer.parseInt(SSL_PORT);
        int nonSSLport = Integer.parseInt(NON_SSL_PORT);

        // Create SSL Server Socket
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Accepting client
        while (true) {
            try {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Client accepted");

                // Performing authentication
                if (authenticateClient(sslSocket)) {
                    new ClientHandler(sslSocket).start();
                } else {
                    sslSocket.close();
                    System.out.println("Authentication failed, client disconnected");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean authenticateClient(SSLSocket sslSocket) {
        // Authentication code goes here.
        // For this example, let's assume a simple user name/password validation.
        String user = sslSocket.getRemoteSocketAddress().toString();
        return "user".equals(user);
    }

    private static class ClientHandler extends Thread {
        private final SSLSocket socket;

        public java_16324_SocketServer_A07(SSLSocket socket) {
            this.socket = socket;
        }

        public void run() {
            // Handle client data here
        }
    }
}