import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_13171_SocketServer_A08 {

    public static final String SSL_KEYSTORE = "keystore.jks";
    public static final String SSL_KEYSTORE_PASSWORD = "password";
    public static final String SSL_TRUSTSTORE = "truststore.jks";
    public static final String SSL_TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {

        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(new FileInputStream(SSL_KEYSTORE), SSL_KEYSTORE_PASSWORD.toCharArray());

            KeyStore truststore = KeyStore.getInstance("JKS");
            truststore.load(new FileInputStream(SSL_TRUSTSTORE), SSL_TRUSTSTORE_PASSWORD.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyStore(keystore);
            sslServerSocketFactory.setKeyStorePassword(SSL_KEYSTORE_PASSWORD);
            sslServerSocketFactory.setTrustStore(truststore);
            sslServerSocketFactory.setTrustStorePassword(SSL_TRUSTSTORE_PASSWORD);

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            socket = (SSLSocket) serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String request, response;
            while ((request = in.readLine()) != null) {
                response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain; charset=UTF-8\r\n" +
                        "\r\n" +
                        "Hello, client, your data is processed securely by SSL/TLS.\r\n";
                out.println(response);
            }

        } finally {
            socket.close();
            serverSocket.close();
        }
    }
}