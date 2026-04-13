import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_33242_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        // Load the keystore containing the SSL certificate and private key
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream is = SocketServer.class.getResourceAsStream("/client.jks")) {
            keyStore.load(is, "password".toCharArray());
        }

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8443);
        serverSocket.setNeedClientAuth(true);
        serverSocket.setKeyStore(keyStore);
        serverSocket.setKeyStorePassword("password");

        System.out.println("Waiting for client connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getChannel());
        sslSocket.startHandshake();

        InputStream input = sslSocket.getInputStream();
        OutputStream output = sslSocket.getOutputStream();

        // Here, you could send or receive messages from the client

        // Close the ssl socket and server socket
        sslSocket.close();
        serverSocket.close();
    }
}