import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_13724_SocketServer_A07 {
    private static SSLServerSocket sslServerSocket = null;
    private static Socket sock = null;
    private static InputStream inputStream = null;
    private static OutputStream outputStream = null;

    public static void main(String[] args) {
        // Setup the KeyStore
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(SocketServer.class.getResourceAsStream("/keystore.jks"), "password".toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Setup the truststore
        KeyStore trustStore = null;
        try {
            trustStore = KeyStore.getInstance("JKS");
            trustStore.load(SocketServer.class.getResourceAsStream("/truststore.jks"), "password".toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Setup a new SSLServerSocket
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(5000, keyStore, trustStore);
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Accept a client connection
        try {
            sock = sslServerSocket.accept();
            sock.setNeedClientAuth(true);
            Certificate[] certificates = sock.getEnabledCipherSuites();
            for (Certificate c : certificates) {
                System.out.println(c.getAlgorithm());
            }
            inputStream = sock.getInputStream();
            outputStream = sock.getOutputStream();

            // Send the response
            String response = "Hello, Client!";
            outputStream.write(response.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}