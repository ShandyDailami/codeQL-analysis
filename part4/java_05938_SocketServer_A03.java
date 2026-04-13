import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManagerFactory;

public class java_05938_SocketServer_A03 {

    private static final String JKS_PATH = "/path/to/your/keystore.jks";
    private static final String JKS_PASSWORD = "yourpassword";
    private static final String ALGORITHM = "SunJSSE";

    public static void main(String[] args) {
        KeyStore keyStore;
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(SocketServer.class.getResourceAsStream(JKS_PATH), JKS_PASSWORD.toCharArray());
        } catch (CertificateException | IOException | java.security.NoSuchAlgorithmException e) {
            throw new ExceptionInInitializerError(e);
        }

        KeyManagerFactory kmf = null;
        try {
            kmf = KeyManagerFactory.getInstance(ALGORITHM);
            kmf.init(keyStore, JKS_PASSWORD.toCharArray());
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }

        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(new ServerSocket(8080), kmf, SSLServerSocket.getDefaultCipherSuite());
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }

        while (true) {
            try {
                Socket clientSocket = sslServerSocket.accept();
                SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
                sslSocket.setNeedClientAuth(true);
                System.out.println("Client connected");
                // TODO: handle the client connection, e.g. read and write data

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}