import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_31544_SocketServer_A01 {
    private static final String CLIENT_KEY_STORE = "client.jks";
    private static final String CLIENT_KEY_ALIAS = "client";
    private static final String SERVER_KEY_STORE = "server.jks";
    private static final String SERVER_ALIAS = "server";
    private static SSLServerSocket sslServerSocket;
    private static SSLSocket sslSocket;
    private static BufferedReader inFromClient;
    private static PrintWriter outToClient;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        sslServerSocket.setNeedClientAuth(true);
        KeyStore clientKeystore = KeyStore.getInstance("JKS");
        clientKeystore.load(new FileInputStream(CLIENT_KEY_STORE), "password".toCharArray());
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream("src/resources/truststore.jks"), "password".toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunPKCS11");
        keyManagerFactory.init(clientKeystore, "password".toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, trustManagerFactory, null);
        sslServerSocket.setSSLContext(sslContext);

        while (true) {
            sslSocket = (SSLServerSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
            inFromClient = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            outToClient = new PrintWriter(sslSocket.getOutputStream(), true);

            System.out.println("Connection from " + sslSocket.getRemoteSocketAddress());

            String message;
            while ((message = inFromClient.readLine()) != null) {
                System.out.println("Received: " + message);
                outToClient.println(message);
            }
        }
    }
}