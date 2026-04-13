import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;

public class java_34305_SocketServer_A08 {
    private static final int PORT = 8080;
    private static SSLServerSocket sslServerSocket;

    public static void main(String[] args) {
        try {
            SSLContext sslContext = getSSLContext();
            sslServerSocket = (SSLServerSocket) sslContext.getServerSocket(PORT);

            while (true) {
                Socket socket = sslServerSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();

                // Here you can handle the socket or send a response to the client
                // For the purpose of the example, let's just print a message
                System.out.println("Client connected");

                // Close the socket
                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SSLContext getSSLContext() throws KeyStoreException, CertificateException, IOException {
        char[] password = "password".toCharArray();
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream("/client.jks"), password);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, password, null);

        return sslContext;
    }
}