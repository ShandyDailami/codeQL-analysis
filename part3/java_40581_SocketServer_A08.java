import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_40581_SocketServer_A08 {
    private static final String PASSWORD = "securePassword";
    private static final String ALGORITHM = "SHA-1";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Create SSLServerSocket with a truststore containing all certificates
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
            sslServerSocket.setNeedClientAuth(true);

            // Create a KeyStore and import a TrustStore from a file
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(new FileInputStream("truststore.jks"), PASSWORD.toCharArray());

            // Create a KeyStore and import a Certificate from a file
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream("keystore.jks"), PASSWORD.toCharArray());

            // Setup KeyManagerFactory with our KeyStore
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, PASSWORD.toCharArray());

            // Setup SSLContext with our TrustStore and KeyManagers
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory, trustStore, null);

            serverSocket = (ServerSocket) sslServerSocket.createContext(sslContext);

            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Connected to client!");

                // Send a response to the client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Hello, client!");

                socket.close();
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}