import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class java_28227_SocketServer_A07 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {

        // Create a server socket using SSL
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) SSLServerSocket.createServerSocket(1234, 1024);
            serverSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Accept client connections
        while (true) {
            SSLSocket socketConnection = null;
            try {
                socketConnection = (SSLSocket) serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            // If client connection is authenticated, send a response
            if (socketConnection.isAuthenticated()) {
                try (PrintWriter out = new PrintWriter(socketConnection.getOutputStream(), true)) {
                    out.println("Hello client, you are now authenticated!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // If client connection is not authenticated, close the connection
                try (socketConnection) {
                    throw new RuntimeException("Client failed to authenticate.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}