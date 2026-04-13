import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.logging.Logger;

public class java_36759_SocketServer_A07 {
    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, 1024);
            serverSocket.setNeedClientAuthentication(true);
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setNeedClientAuthentication(true);
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // Send a welcome message
            outputStream.write("Welcome to the server! ".getBytes());
            outputStream.flush();

            byte[] bytes = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, bytesRead);
            }
            outputStream.flush();

            clientSocket.close();
        } catch (Exception e) {
            logger.severe("Exception caught: " + e.getMessage());
        }
    }
}