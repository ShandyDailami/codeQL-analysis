import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_03917_SocketServer_A08 {

    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, 10, false, false);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.setNeedClientAuth(true);

                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();

                // Send response to the client
                String response = "Hello World";
                outputStream.write(response.getBytes());

                sslSocket.close();
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Exception caught", ex);
        }
    }
}