import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_21728_SocketServer_A08 {
    private static final String CLIENT_CERT = "src/client.jks"; // Path to your client certificate
    private static final String CLIENT_KEY = "src/client.key"; // Path to your client key
    private static final String TRUSTSTORE_PWD = "truststore_password"; // Truststore password
    private static final String KEY_PASSWORD = "keystore_password"; // Keystore password

    public static void main(String[] args) throws Exception {
        // Load client certificate and key
        KeyStore clientStore = KeyStore.getInstance("JKS");
        clientStore.load(new FileInputStream(CLIENT_CERT), TRUSTSTORE_PWD.toCharArray());

        // Load server certificate and key
        KeyStore serverStore = KeyStore.getInstance("JKS");
        serverStore.load(new FileInputStream(CLIENT_CERT), TRUSTSTORE_PWD.toCharArray());

        // Setup SSLContext
        SSLServerSocket serverSocket = new SSLServerSocket(443, null, clientStore, serverStore);
        SSLServerSocketFactory sslSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketFactory();
        SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket(serverSocket, true);
        socket.setNeedClientAuth(true);

        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(serverStore, clientStore, new java.security.SecureRandom());
        socket.setSSLContext(sslContext);

        // Accept connections
        while (true) {
            Socket connection = serverSocket.accept();
            System.out.println("Client connected");

            OutputStream out = connection.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello Client, You are Connected!");
        }
    }
}