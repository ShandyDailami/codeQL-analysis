import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_13162_SocketServer_A08 {
    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080, 1024, InetAddress.getByName("localhost"));
            serverSocket.setReuseAddress(true);
            SSLServerSocket sslServer = (SSLServerSocket) serverSocket;
            sslServer.setNeedClientAuth(true);
            
            // Load trusted certificate and private key
            sslServer.setCertificateExtensions(new String[]{"TLSv1.2"});
            sslServer.setEnabledCipherSuites(new String[]{"TLSv1.2"});
            sslServer.setSupportedProtocols(new String[]{"TLSv1.2"});

            while (true) {
                Socket socket = sslServer.accept();
                logger.log(Level.INFO, "Accepted connection from " + socket.getRemoteSocketAddress());
                new HandlerThread(socket).start();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception caught", ex);
        }
    }
}