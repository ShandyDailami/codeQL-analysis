import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class java_02211_SocketServer_A07 {

    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());

    private static SSLServerSocket sslServerSocket = null;

    private static void setupServer(int port) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
        sslServerSocket.setNeedClientAuth(true);
    }

    private static void createSSLSocket(ServerSocket serverSocket) throws IOException {
        Socket sslSocket = sslServerSocket.accept();
        sslSocket.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
        sslSocket.setSSLContext(sslContext);
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        sslSocket = (SSLSocket) sslSocketFactory.createSocket(serverSocket.getInetAddress(), serverSocket.getPort());
    }

    private static void handle(SSLSocket sslSocket) {
        InputStream inputStream = sslSocket.getInputStream();
        // process inputStream
        sslSocket.close();
    }

    public static void main(String[] args) {
        try {
            setupServer(8443); // change to your port
            while (true) {
                createSSLSocket(sslServerSocket);
                handle(sslSocket);
            }
        } catch (IOException e) {
            LOGGER.severe(e.toString());
        }
    }
}