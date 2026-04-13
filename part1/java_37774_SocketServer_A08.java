import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.security.KeyStore;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_37774_SocketServer_A08 {

    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "yourpassword";
    private static final String TRUSTSTORE_LOCATION = "/path/to/your/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "yourpassword";
    private static final int HTTPS_PORT = 8443;
    private static final int HTTP_PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket httpServer = new ServerSocket(HTTP_PORT);
        SSLServerSocket sslServer = (SSLServerSocket) new SSLServerSocketFactory(
                createKeyStore("server", KEYSTORE_PASSWORD),
                createTrustStore(),
                SSLServerSocketFactory.getDefaultAlgorithm()).createServerSocket(HTTPS_PORT);

        while (true) {
            Socket socket = sslServer.accept();
            SSLSocket sslSocket = (SSLSocket) socket.createChannel();
            sslSocket.setNeedClientAuthentication(true);
            sslServer.accept();
            handleRequest(sslSocket);
            sslSocket.close();
        }
    }

    private static void handleRequest(SSLSocket sslSocket) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        String request;
        while ((request = in.readLine()) != null) {
            out.println(request);
        }
    }

    private static KeyStore createKeyStore(String alias, String password) throws Exception {
        char[] passwordCharArray = password.toCharArray();
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new java.security.cert.CertificateRequest(
                null,
                null,
                null,
                null,
                passwordCharArray),
                password.toCharArray());
        return keyStore;
    }

    private static KeyStore createTrustStore() throws Exception {
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new java.security.cert.CertificateRequest(
                null,
                null,
                null,
                null,
                null),
                null);
        return trustStore;
    }
}