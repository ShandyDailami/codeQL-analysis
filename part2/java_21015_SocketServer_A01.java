import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_21015_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        // Set up a KeyStore that trusts all certificates
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/truststore.jks"), "truststorepassword".toCharArray());
        } catch (CertificateException | IOException | NullPointerException e) {
            e.printStackTrace();
        }

        // Set up the server socket factory with SSL and truststore
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword("keystorepassword".toCharArray());

        try (ServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT)) {
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                clientSocket.setWantServerSideAccept(true);

                // Handle client request
                InetAddress remoteAddress = clientSocket.getInetAddress();
                System.out.println("Accepted connection from " + remoteAddress);

                new Handler(clientSocket).start();
            }
        } catch (IOException | NullPointerException | ClassCastException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private final Socket socket;

        public java_21015_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Handle client request here
        }
    }
}