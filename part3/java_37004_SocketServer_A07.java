import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_37004_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            // Create a server socket
            serverSocket = new ServerSocket(8080);

            // Create an SSL server socket
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("src/main/resources/keystore.jks"), "password".toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKeyStore");
            keyManagerFactory.init(keyStore, "password".toCharArray());
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) sslServerFactory.getServerSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            // Accept a client connection
            socket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setNeedClientAuth(true);

            // Perform SSL handshake
            sslSocket.handshake();

            // Send a response
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            out.println("Hello, Client!");

        } finally {
            socket.close();
            sslServerSocket.close();
            serverSocket.close();
        }
    }
}