import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_10647_SocketServer_A03 {
    private static final String SSL_PROTOCOL = "SSL";
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            // Load the key store and create a SSLServerSocket
            KeyStore keyStore = KeyStore.getInstance(SSL_PROTOCOL);
            keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) keyStore.getSSLServerSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);

            // Accept a connection and create a SSLSocket
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            // Write a response
            OutputStream outToClient = clientSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outToClient, true);
            out.println("Server: Hello Client, How are you?");

            // Close the connection
            clientSocket.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}