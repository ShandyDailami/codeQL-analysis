import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_25171_SocketServer_A03 {
    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        // Create a SSLServerSocket factory and use a custom SSL context
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, 10, InetAddress.getByName("localhost"))) {
            // Setup the SSL socket
            SSLSocket socket = (SSLSocket) sslServerSocket.accept();
            socket.setNeedClientAuth(true);
            socket.startHandshake();
            LOGGER.info("Connection established: " + socket.getRemoteSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}