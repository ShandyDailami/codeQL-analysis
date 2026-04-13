import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_00365_SocketServer_A03 {

    private static final String SSL_PORT = "4444";
    private static final String NORMAL_PORT = "4445";

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server...");

        // Create SSL Server Socket
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(Integer.parseInt(SSL_PORT));

        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("Accepted connection from " + socket.getInetAddress().getHostAddress());

            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            // Perform operations related to injection.
            // ...

            // Close the socket
            sslSocket.close();
        }
    }
}