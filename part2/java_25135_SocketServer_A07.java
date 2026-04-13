import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_25135_SocketServer_A07 {

    public static void main(String[] args) {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            // Load the keystore containing server private key
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("keystore.jks"), "password".toCharArray());

            // Create SSLServerSocket with the keyStore and trustStore
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(keyStore, "trustStore".toCharArray());

            // Wait for client connection
            socket = sslServerSocket.accept();

            // Get InputStream and OutputStream from the socket
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Write to the outputStream
            outputStream.write("Hello, Client!".getBytes());

            // Close the streams
            outputStream.close();
            inputStream.close();

            // Close the socket
            socket.close();

            // Close the sslServerSocket
            sslServerSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}