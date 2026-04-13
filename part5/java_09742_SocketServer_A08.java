import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class java_09742_SocketServer_A08 {

    private final static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            // Create a SSLServerSocket on the specified port and
            // wrap it with SSLServerSocket.
            serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);

            SSLSocket socket;
            while (true) {
                // Block and wait for a connection.
                socket = (SSLSocket) serverSocket.accept();

                // Perform client auth.
                socket.startHandshake();
                if (!socket.isAuthenticated()) {
                    socket.close();
                    System.out.println("Authentication failed!");
                    continue;
                }

                // Handle connection.
                new Handler(socket).start();
            }
        } finally {
            // Close the SSLServerSocket.
            serverSocket.close();
        }
    }
}