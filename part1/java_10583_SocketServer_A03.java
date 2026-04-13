import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class java_10583_SocketServer_A03 {

    public static void main(String[] args) {

        // Load the Bouncy Castle provider
        if (!java.security.Security.getProperties().getProperty("java.security.provider").equals("BC")) {
            System.setProperty("java.security.provider", "BC");
        }
        java.security.Provider bcProvider = new BouncyCastleProvider();
        java.security.Security.addProvider(bcProvider);

        try {
            // Create a KeyStore using JKS
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("keystore.jks"), "password".toCharArray());

            // Create a SSLServerSocketFactory using our KeyStore
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory = sslServerSocketFactory.setKeyStore(ks);

            // Create a new SSLServerSocket
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setReuseAddress(true);

            // Accept a client connection
            Socket socket = sslServerSocket.accept();
            System.out.println("Client connected");

            // Create a SSLSocket using our SSLServerSocket
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            // Get the remote IP
            InetAddress remoteAddress = sslSocket.getRemoteSocketAddress();
            System.out.println("Remote address is: " + remoteAddress);

            // Send a message to the client
            sslSocket.getOutputStream().write("Hello, Client!".getBytes());
            sslSocket.getOutputStream().flush();
            sslSocket.getOutputStream().close();

            // Close the sockets
            socket.close();
            sslSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}