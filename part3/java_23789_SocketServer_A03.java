import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_23789_SocketServer_A03 {

    private static final String KEYSTORE_LOCATION = "path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "yourpassword";
    private static final String KEY_ALIAS = "youralias";

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            // Load certificate from keystore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, KEYSTORE_PASSWORD.toCharArray());

            SSLServerSocket serverSocketSecure = (SSLServerSocket) serverSocket.accept();
            serverSocketSecure.setNeedClientAuth(true);

            SSLSocket socketSecure = (SSLSocket) serverSocketSecure.accept();

            // Start accepting connections
            socketSecure.startHandshake();

            System.out.println("Handshake complete, SSL version: " + socketSecure.getProtocolVersion());

            InputStream input = socketSecure.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Received: " + line);
            }

            socketSecure.close();
            serverSocketSecure.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}