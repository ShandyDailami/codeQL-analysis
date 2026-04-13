import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_29105_SocketServer_A03 {

    private static final String KEYSTORE = "mykeystore.jks";
    private static final String KEYSTORE_PASSWORD = "mypassword";
    private static final String TRUSTSTORE = "mytruststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "mypassword";
    private static final String KEY_ALIAS = "mykey";

    public static void main(String[] args) throws KeyStoreException, CertificateException, IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        // Create the keystore and truststore.
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream("/mykeystore.jks"), KEYSTORE_PASSWORD.toCharArray());

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(getClass().getResourceAsStream("/mytruststore.jks"), TRUSTSTORE_PASSWORD.toCharArray());

        // Setup the SSLSocket server socket factory with the key store and trust store.
        SSLServerSocketFactory sslServerSocketFactoryWithKeyStoreAndTrustStore = new SSLServerSocketFactory(keyStore, trustStore, new java.security.cert.TrustStrategy(){
            public boolean trust(String s, SSLSocket sslsocket) {
                return true;
            }
        });

        // Bind the server socket to port 8443, using the SSLServerSocketFactory.
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactoryWithKeyStoreAndTrustStore.createServerSocket(8443);

        // Create and bind the server socket.
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(sslServerSocket);

        while (true) {
            System.out.println("Waiting for client on port 8443...");
            Socket clientSocket = serverSocket.accept();

            // Handle client connection securely.
            SSLSocket sslSocket = (SSLSocket) sslServerSocketFactoryWithKeyStoreAndTrustStore.createSocket(clientSocket, clientSocket.getInetAddress(), true, false);
            sslSocket.startHandshake();

            // Get the certificate from the client.
            SSLCertificate cert = (SSLCertificate) sslSocket.getSession().getPeerCertificate();
            System.out.println("Client certificate: " + cert);

            // Send and receive data.
            DataInputStream in = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());
            out.writeUTF("Hello Client!");
            String serverResponse = in.readUTF();
            System.out.println("Server Response: " + serverResponse);

            sslSocket.close();
        }
    }
}