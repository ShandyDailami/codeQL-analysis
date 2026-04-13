import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.security.*;

public class java_18663_SocketServer_A07 {

    private static final int PORT = 8080;
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket sock = null;
        SSLServerSocket ssock = null;

        try {
            // Create a KeyStore with a password
            KeyStore keyStore = KeyStore.getInstance("JKS");
            char[] password = PASSWORD.toCharArray();
            keyStore.load(new FileInputStream("keystore.jks"), password);

            // Create a PrivateKey and a Certificate
            Key privateKey = keyStore.getKey("alias", password);
            Certificate certificate = keyStore.getCertificate("alias").getCertificate();

            // Create a SSLContext with the private key and certificate
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, new Key[] { privateKey }, new java.security.SecureRandom());

            // Create a ServerSocket
            sock = new ServerSocket(PORT);
            ssock = (SSLServerSocket) sock.accept();

            // Create a SSLSocket and wrap it with SSLSocketFactory
            SSLSocket sslSock = (SSLSocket) ssock.accept();
            SSLSocketFactory sslSockFactory = sslContext.getSocketFactory();
            sslSock = (SSLSocket) sslSockFactory.createSocket(sslSock, sslSock.getRemoteSocketAddress());

            // Create a BufferedReader and BufferedWriter
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSock.getInputStream()));
            PrintWriter writer = new PrintWriter(sslSock.getOutputStream(), true);

            // Create a SecurityManager with a new Policy
            SecurityManager sm = new SecurityManager() {
                @Override
                public boolean authenticate(String s, String s1) throws AuthFailure {
                    return s1.equals(PASSWORD);
                }
            };

            // Set the SecurityManager on the SSLSocket
            sslSock.setSecurityManager(sm);

            // Send and receive messages
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
           
                // Write response
                writer.println("Hello, client!");
                writer.flush();
            }
        } finally {
            sock.close();
            ssock.close();
        }
    }
}