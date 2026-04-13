import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_34222_SocketServer_A07 {
    private static final String SSL_KEYSTORE_PATH = "path_to_your_keystore.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String SSL_TRUSTSTORE_PATH = "path_to_your_truststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);

            System.out.println("Waiting for client connection...");
            socket = serverSocket.accept();
            System.out.println("Client connected!");

            SSLSocket sslSocket = (SSLSocket) socket.getShared();

            sslSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, null, null);

            sslSocket.setSSLContext(sslContext);

            // Here you can write your server logic related to authentication failure
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (socket != null) socket.close();
        }
    }
}