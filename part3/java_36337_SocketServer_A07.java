import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_36337_SocketServer_A07 {
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        // Load SSL certificate and private key
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream is = new FileInputStream("path_to_your_keystore.jks")) {
            keyStore.load(is, "password".toCharArray());
        }

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4433);
        serverSocket.setNeedClientAuthentication(true);

        // Establish SSL connection
        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
        clientSocket.setNeedClientAuthentication(true);

        // Perform handshake
        SSLSession sslSession = clientSocket.getSession();
        sslSession.setCipherSuites(new String[] { "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384" });
        sslSession.setProtocols(new String[] { "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2" });

        // Read response
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Thank you for connecting to " + clientSocket.getRemoteSocketAddress() + "!");
        String response = in.readLine();
        System.out.println("Server: " + response);

        // Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}