import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_33061_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        // Load the certificate and key
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunPKCS11");
        keyManagerFactory.init(keyStore, "password".toCharArray());
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);

        // Setup SSLSocket with the key and trust manager
        SSLServerSocket serverSocketSSL = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
        serverSocketSSL.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, trustManagerFactory, new java.security.SecureRandom());
        clientSocket = serverSocketSSL.accept();
        clientSocket.setSSLSocket(serverSocketSSL);
        serverSocketSSL.setNeedClientAuth(true);

        System.out.println("Handshake completed");

        // Send response
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Hello Client, you are now connected to " + clientSocket.getRemoteSocketAddress());
    }
}