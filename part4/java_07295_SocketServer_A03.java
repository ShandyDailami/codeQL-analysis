import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_07295_SocketServer_A03 {

    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());

    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore", "server.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");
        System.setProperty("javax.net.ssl.trustStore", "client.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT)) {
            while (true) {
                try (SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept()) {
                    try (InputStream inputStream = sslSocket.getInputStream(); OutputStream outputStream = sslSocket.getOutputStream()) {
                        // process input and output
                    }
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "I/O error: " + ex);
        }
    }
}