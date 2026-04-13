import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class java_17511_SocketServer_A08 {

    private static final String KEYSTORE = "keystore.jks";
    private static final char[] KEYSTORE_PASSWORD = "password".toCharArray();
    private static final char[] PASSWORD = "password".toCharArray();
    private static final String ALIAS = "alias";

    public static void main(String[] args) throws Exception {
        final SSLContext sslContext = createSSLContext();
        final ServerSocket serverSocket = createServerSocket(sslContext, 12345);

        while (true) {
            try {
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                sslSocket.setNeedClientAuthentication(true);

                sslSocket.startHandshake();

                if (sslSocket.getNeedClientAuthentication()) {
                    InetAddress address = sslSocket.getRemoteSocketAddress();
                    System.out.println("Client " + address + " has authenticated");
                }

                sslSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static ServerSocket createServerSocket(SSLContext sslContext, int port) throws Exception {
        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(port);
        serverSocket.setNeedClientAuth(true);
        return serverSocket;
    }

    private static SSLContext createSSLContext() throws Exception {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(new KeyStoreInputStream(KEYSTORE, KEYSTORE_PASSWORD));

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
        return sslContext;
    }
}