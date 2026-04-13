import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_02231_SocketServer_A08 {

    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "yourkeystorepassword";
    private static final String KEY_PASSWORD = "yourkeypassword";
    private static SSLServerSocket sslServerSocket = null;

    public static void main(String[] args) throws Exception {

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, KEY_PASSWORD.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory().newServerSocketFactory();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);

        SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.accept();
        sslServerSocket.setNeedClientAuth(true);

        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.setNeedClientAuth(true);

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            out.println(message);
        }

        sslServerSocket.close();
    }
}