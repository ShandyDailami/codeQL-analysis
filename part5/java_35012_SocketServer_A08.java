import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_35012_SocketServer_A08 {
    private static final String KEY_STORE = "mykeystore";
    private static final char[] KEY_STORE_PASSWORD = "mypassword".toCharArray();
    private static final char[] TOKEN_PASSWORD = "tokencode".toCharArray();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Create a KeyStore with a single entry for the server
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEY_STORE), KEY_STORE_PASSWORD);

            // Create a truststore with a single entry for the client
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("truststore"), TOKEN_PASSWORD);

            sslServerSocket = (SSLServerSocket) keyStore.getServerSocketFactory().createServerSocket(4444);
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setKeyStore(keyStore);
            sslServerSocket.setTrustStore(trustStore);

            // Accept SSL/TLS connections
            Socket clientSocket = sslServerSocket.accept();

            // Get the input and output streams
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // Send a greeting to the client
            outputStream.write("Hello, Client\r\n".getBytes());

            // Close the input and output streams
            outputStream.close();
            inputStream.close();

            // Close the client socket
            clientSocket.close();

            // Close the server socket
            sslServerSocket.close();
        } catch (IOException | CertificateException e) {
            e.printStackTrace();
        }
    }
}