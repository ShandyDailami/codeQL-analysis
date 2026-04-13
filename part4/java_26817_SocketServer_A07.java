import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_26817_SocketServer_A07 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server...");

        // Load server's keystore and truststore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("client.jks"), "password".toCharArray());

        // Load client's truststore
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream("server.jks"), "password".toCharArray());

        // Create a truststore containing the CertificateAuthorities from the KeyStore
        KeyStore trustStoreFromStore = KeyStore.getInstance("JKS");
        trustStoreFromStore.load(new FileInputStream("ca.jks"), "password".toCharArray());
        TrustStore trustStoreReference = new PKIXTrustStore(new FileInputStream(trustStoreFromStore));

        // Create a KeyStore containing a private key and a certificate
        KeyStore keyStoreReference = keyStore;

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory = sslServerFactory(keyStoreReference, trustStoreReference);

        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8888);
        serverSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            if (clientSocket.getSession() != Session.SUCCESSFUL) {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Auth failure");
                clientSocket.close();
                continue;
            }

            OutputStream out = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello World");

            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String serverMessage;
            while ((serverMessage = reader.readLine()) != null) {
                System.out.println("Server says: " + serverMessage);
            }

            clientSocket.close();
        }
    }

    public static SSLServerSocketFactory sslServerFactory(KeyStore keyStore, TrustStore trustStore) throws KeyManagementException {
        SSLServerSocketFactory sslServerSocketFactory = null;

        SSLServerSocket sslServerSocket = null;

        KeyManagementFactory keyManagementFactory = KeyManagementFactory.getInstance("KeyManagementFactory");
        keyManagementFactory.init(keyStore, null);

        KeyStore trustStoreReference = trustStore;

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory = sslServerSocketFactory.configure(new SSLContext(keyManagementFactory), true);

        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8888);

        return sslServerSocketFactory;
    }
}