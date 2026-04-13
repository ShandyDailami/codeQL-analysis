import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.KeyStoreException;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_07017_SocketServer_A01 {

    private final int port;
    private SSLServerSocket serverSocket;
    private SSLContext sslContext;

    public java_07017_SocketServer_A01(int port) {
        this.port = port;
        initialize();
    }

    private void initialize() {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/keystore.jks"), "password".toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "password".toCharArray());

            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory, null, null);

            serverSocket = (SSLServerSocket) sslContext.getServerSocket(port);
        } catch (NoSuchAlgorithmException | KeyStoreException | IOException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        SSLSocket client = (SSLSocket) serverSocket.accept();
                        client.setNeedClientAuth(true);
                        X509Certificate[] certs = client.getEnabledCipherSuites();
                        for (X509Certificate cert : certs) {
                            System.out.println("Client Certificate: " + cert.toString());
                        }
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new SecureSocketServer(8443).start();
    }
}