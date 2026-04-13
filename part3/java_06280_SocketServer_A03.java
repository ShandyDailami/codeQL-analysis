import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_06280_SocketServer_A03 {
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";
    private static final SSLServerSocketFactory SERVER_SOCKET_FACTORY = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

    public static void main(String[] args) {
        System.out.println("Starting secure socket server...");

        SSLServerSocket serverSocket = null;

        try {
            // Load the keystore
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

            // Set up the key manager factory to use our keystore
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKSAPI");
            keyManagerFactory.init(keystore, KEY_PASSWORD.toCharArray());

            // Set up the trust manager factory to trust all certificates
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunJSSE");
            trustManagerFactory.init(keystore);

            // Set up the SSLSocketFactory with our key and trust managers
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SERVER_SOCKET_FACTORY;
            sslServerSocketFactory.setKeyManagers(keyManagerFactory.getKeyManagers());
            sslServerSocketFactory.setTrustManagers(trustManagerFactory.getTrustManagers());

            // Create a new SSLServerSocket and bind it to port 1234
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
            serverSocket.setReuseAddress(true);

            // Start accepting client connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted client connection from " + clientSocket.getRemoteSocketAddress());

                // Create a new SSLSocket and wrap the client socket in an SSLSocketFactory
                SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(clientSocket, clientSocket.getRemoteSocketAddress(), true, false);
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();

                // Handle the client connection here
                // ...

                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}