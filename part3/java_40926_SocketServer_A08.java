import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_40926_SocketServer_A08 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        createServerSocket(8080);
        System.out.println("Secure Socket Server started on port 8080");

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            System.out.println("New client connected");

            // Write your logic here to handle the client connection

            clientSocket.close();
        }
    }

    private static void createServerSocket(int port) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

        // Enable server to accept client for 10 seconds
        serverSocket.setSoTimeout(10000);

        KeyStore keyStore = KeyStore.getInstance("JKS");
        char[] password = "password".toCharArray();
        keyStore.load(new FileInputStream("path/to/your/keystore.jks"), password);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, null, null);

        serverSocket.setSSLContext(sslContext);
    }
}