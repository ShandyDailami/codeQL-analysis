import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.*;

public class java_22099_SocketServer_A03 {

    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());
    private static final int PORT = 8888;
    private static SSLServerSocket sslServerSocket;
    private static Socket socket;
    private static SSLContext sslContext;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuth(true);
            socket = sslServerSocket.accept();
            LOGGER.log(Level.INFO, "Client connected");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error accepting client connection", e);
        }
    }

    static {
        try {
            SSLServerSocket socket = new SSLServerSocket(PORT);
            SSLContext context = SSLContext.getInstance("TLSv1.2");
            context.init(null, new TrustManager[] { new InsecureTrustManager() }, new java.security.SecureRandom());
            socket.accept();
            LOGGER.log(Level.INFO, "Server initiated");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error initializing server socket", e);
        }
    }
}