import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_21223_SocketServer_A08 {
    private static final String CLIENT_KEYSTORE = "client.jks";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_KEYSTORE = "server.jks";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE = "truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8888, null, null, SSLServerSocket.CIPHER_LIST_ALL);
        sslServerSocket.setNeedClientAuth(true);

        KeyStore clientKeystore = KeyStore.getInstance("JKS");
        clientKeystore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());

        TrustStore trustStore = new J trustStore();
        trustStore.load(new FileInputStream(TRUSTSTORE), TRUSTSTORE_PASSWORD.toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(clientKeystore, trustStore, null);

        Socket socket = sslServerSocket.accept();
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.setNeedClientAuth(true);
        sslSocket.setSSLContext(sslContext);

        DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());
        out.writeUTF("Welcome to Socket Server!");

        sslSocket.close();
        socket.close();
    }
}