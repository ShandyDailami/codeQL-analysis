import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_09707_SocketServer_A01 {
    private static final String SSL_SERVER_KEYSTORE = "path_to_your_keystore_file";
    private static final String SSL_SERVER_KEYSTORE_PASSWORD = "password_for_keystore";
    private static final String SSL_SERVER_TRUSTSTORE = "path_to_your_truststore_file";
    private static final String SSL_SERVER_TRUSTSTORE_PASSWORD = "password_for_truststore";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuthentication(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(SSL_SERVER_KEYSTORE), SSL_SERVER_KEYSTORE_PASSWORD.toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream(SSL_SERVER_TRUSTSTORE), SSL_SERVER_TRUSTSTORE_PASSWORD.toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, new TrustStorePasswordCallback(trustStore, SSL_SERVER_TRUSTSTORE_PASSWORD));

            while (true) {
                clientSocket = serverSocket.accept();
                clientSocket.setNeedClientAuthentication(true);
                SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
                clientSocket = (SSLSocket) sslSocketFactory.createSocket(clientSocket, clientSocket.getInetAddress(), 12345, true);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Read request
                String request = in.readLine();
                System.out.println("Server received: " + request);

                // Send response
                out.writeBytes("Hello, client!\n");
                out.flush();

                clientSocket.close();
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (clientSocket != null) clientSocket.close();
        }
    }

    private static class TrustStorePasswordCallback implements Callback {
        private KeyStore trustStore;
        private String trustStorePassword;

        public java_09707_SocketServer_A01(KeyStore trustStore, String trustStorePassword) {
            this.trustStore = trustStore;
            this.trustStorePassword = trustStorePassword;
        }

        public String getPassword(String key) {
            return trustStorePassword;
        }

        public String getDefaultPassword(String key) {
            return trustStorePassword;
        }
    }
}