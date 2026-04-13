import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_07565_SocketServer_A01 {

    private static final Logger LOGGER = Logger.getLogger(SecureServer.class.getName());

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, 50000, InetAddress.getByName("localhost"));
            sslServerSocket.setNeedClientAuth(true);
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            sslSocket.setNeedClientAuth(true);

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            // Here you can write code to handle the communication with the client.

            sslSocket.close();

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accepting client connection", ex);
        }
    }
}