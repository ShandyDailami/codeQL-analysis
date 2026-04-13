import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_19702_SocketServer_A07 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());
    private static final String CLIENT_MESSAGE = "Hello client";

    public static void main(String[] args) {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, null, InetAddress.getByName("localhost"));

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.setNeedClientAuthentication(true);

                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();

                outputStream.write(CLIENT_MESSAGE.getBytes());
                outputStream.flush();

                byte[] buffer = new byte[256];
                int length = inputStream.read(buffer);
                String message = new String(buffer, 0, length);
                logger.log(Level.INFO, "Server: Received: {0}", message);

                sslSocket.close();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}