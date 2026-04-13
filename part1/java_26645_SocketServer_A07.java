import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_26645_SocketServer_A07 {
    public static void main(String[] args) {
        // Load a KeyStore that contains our private key
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try {
            keyStore.load(SocketServer.class.getResourceAsStream("/keystore.jks"), "password".toCharArray());
        } catch (IOException | CertificateException e) {
            e.printStackTrace();
        }

        // Create a SSLServerSocket with our KeyStore and password
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080, keyStore, "password".toCharArray(),
                    SSLServerSocket.SELECT_CHANNEL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Continuously listen for SSL connections
        while (true) {
            try {
                SSLSocket sslSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the SSLSocket
                // ...

                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}