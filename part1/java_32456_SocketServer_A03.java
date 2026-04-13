import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_32456_SocketServer_A03 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_ALIAS = "your_key_alias";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKSAPI");
            keyManagerFactory.init(keyStore, KEYSTORE_PASSWORD.toCharArray());

            TrustStore trustStore = TrustStore.getInstance("JKS");
            trustStore.load(new FileInputStream(TRUSTSTORE_LOCATION), TRUSTSTORE_PASSWORD.toCharArray());

            KeyStore trustStoreCopy = trustStore; // Use the same truststore for client authentication

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyStore(keyStore);
            sslServerSocketFactory.setKeyManagerFactory(keyManagerFactory);
            sslServerSocketFactory.setTrustStore(trustStoreCopy); // Use the same truststore for client authentication

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443);
            while (true) {
                clientSocket = serverSocket.accept();
                clientSocket.setSoTimeout(60000);
                SSLSocket sslClient = (SSLSocket) sslServerSocketFactory.createClientSocket(clientSocket, null);
                BufferedReader in = new BufferedReader(new InputStreamReader(sslClient.getInputStream()));
                PrintWriter out = new PrintWriter(sslClient.getOutputStream(), true);
                String message;
                while ((message = in.readLine()) != null) {
                    out.println(message);
                }
            }
        } finally {
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
        }
    }
}