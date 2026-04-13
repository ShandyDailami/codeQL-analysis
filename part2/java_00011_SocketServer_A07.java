import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_00011_SocketServer_A07 {

    private static final Logger logger = Logger.getLogger(SecureServer.class.getName());

    public static void main(String[] args) {
        int port = 12345;

        // Step 1: Create a SSL ServerSocketFactory
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            // Step 2: Create a SSLServerSocket
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

            // Step 3: Accept Client Connection
            Socket socket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket;

            // Step 4: Get InetAddress of the Client
            InetAddress inetAddress = sslSocket.getInetAddress();

            logger.info("Accepted connection from : " + inetAddress.toString());

            // Step 5: Start a new thread to handle the communication
            Thread thread = new Thread(new SecureServerThread(sslSocket));
            thread.start();
        } catch (Exception e) {
            logger.severe("Exception in creating ServerSocket " + e.getMessage());
        }
    }
}