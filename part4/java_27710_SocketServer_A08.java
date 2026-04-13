import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_27710_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a KeyStore that contains a private key and a self-signed certificate
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(null, null);

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) sslServerSocketFactory
                    .newServerSocketFactory(keyStore, null);
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory
                    .createServerSocket(8080);

            // Create a new socket and bind it to the port
            Socket socket = serverSocket.accept();
            InetAddress inetAddress = socket.getInetAddress();

            System.out.println("Client socket connected from " + inetAddress.getHostAddress());

            // Close the socket
            socket.close();

        } catch (KeyStoreException | CertificateException | IOException e) {
            e.printStackTrace();
        }
    }
}