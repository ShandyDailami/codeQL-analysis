import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_20875_SocketServer_A07 {
    private static SSLServerSocket sslServerSocket = null;
    private static Socket sslSocket = null;
    private static SSLContext sslContext = null;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);

        sslSocket = sslServerSocket.accept();
        SSLSocket sslSocket1 = (SSLSocket) sslSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket1.getInputStream()));

        PrintWriter out = new PrintWriter(sslSocket1.getOutputStream(), true);

        String serverInput;

        while ((serverInput = in.readLine()) != null) {
            System.out.println("Received from client: " + serverInput);
            out.println("Hello client, your data has been received!");
        }

        sslSocket1.close();
        sslServerSocket.close();
        sslServerSocketFactory.close();
        sslContext.getSupportedCipherSuites();
        sslContext.getDefaultAlgorithm();
        sslContext.getProviders();
        sslContext.getDefaultKeyStorePassword();
        sslContext.getSupportedProtocols();
        sslContext.getDefaultWorkaroundSet();
    }

    static SSLContext createDefaultSslContext() throws KeyManagementException, NoSuchAlgorithmException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream inputStream = SocketServer.class.getResourceAsStream("/server.jks");
        keyStore.load(inputStream, "password".toCharArray());

        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        SSLServerSocketFactory sslServerSocketFactory = sslServerSocket.getServerSocketFactory();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        sslSocket = sslServerSocket.accept();
        sslSocket.setNeedClientAuth(true);

        KeyStore trustStore = KeyStore.getInstance("JKS");
        inputStream = SocketServer.class.getResourceAsStream("/truststore.jks");
        trustStore.load(inputStream, "password".toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(keyStore, trustStore, null);

        return sslContext;
    }
}