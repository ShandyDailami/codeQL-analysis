import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class java_21304_SocketServer_A08 {
    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new ServerSocket(8080);
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            byte[] bytes = new byte[1024];
            int length;
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }

            sslSocket.close();
            sslServerSocket.close();
        } catch (IOException e) {
            logger.severe("Error occurred while handling the client: " + e.getMessage());
        }
    }
}