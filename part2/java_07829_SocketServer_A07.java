import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.Key;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public class java_07829_SocketServer_A07 {

    private static final String KEYSTORE_PATH = "keystore.jks";
    private static final char[] KEYSTORE_PASSWORD = "password".toCharArray();
    private static final char[] KEY_PASSWORD = "keypassword".toCharArray();
    private static final String ALGORITHM = "SunRSADesign";

    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new java.io.FileInputStream(KEYSTORE_PATH), KEYSTORE_PASSWORD);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, KEY_PASSWORD);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

        int port = 8443; // change the port to a higher port number
        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(port);
        serverSocket.setReuseAddress(true);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            SSLSocket sslSocket = (SSLSocket) clientSocket.createChannel();
            sslSocket.setNeedClientAuth(true);
            sslSocket.setSSLContext(sslContext);
            sslSocket.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Server response: " + message);
            }
        }
    }
}