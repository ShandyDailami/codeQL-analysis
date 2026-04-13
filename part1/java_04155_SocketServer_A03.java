import java.net.*;
import java.io.*;
import java.security.*;
import javax.net.ssl.*;

public class java_04155_SocketServer_A03 {

    private static final String SSL_PORT = "4444"; // SSL port
    private static final String SERVER_PORT = "4445"; // Default port

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        ServerSocket serverSocket = null;

        try {
            // Create a SSL ServerSocket
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(Integer.parseInt(SSL_PORT));
            System.out.println("SSL Server started on port: " + SSL_PORT);

            // Accept incoming connections
            serverSocket = new ServerSocket(Integer.parseInt(SERVER_PORT));
            System.out.println("Server started on port: " + SERVER_PORT);

            while (true) {
                SSLSocket sslSocket = sslServerSocket.accept();
                System.out.println("Client connected: " + sslSocket.getRemoteSocketAddress());

                // Create new input and output stream
                DataInputStream dis = new DataInputStream(sslSocket.getInputStream());
                DataOutputStream dos = new DataOutputStream(sslSocket.getOutputStream());

                // Create a keystore and key
                KeyStore keyStore = KeyStore.getInstance("JKS");
                char[] password = "password".toCharArray();
                keyStore.load(new FileInputStream("server.jks"), password);

                // Create a private key
                Key key = keyStore.getKey("key", password);

                // Create a trust manager that trusts all certificates
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(KeyStore.getDefaultType());
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManager = trustManagerFactory.getTrustManagers();

                // Create a SSLContext and initialize it with the key and trust manager
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(key, trustManager, new java.security.SecureRandom());

                // Create a SSLSocketFactory
                SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

                // Create a new socket and wrap the existing socket in an SSL socket
                SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(sslSocket.getInetAddress(), sslSocket.getPort());

                // Set the socket to non-blocking
                sslSocket.setNonBlocking(true);

                // Output message
                dos.writeUTF("SSL/TLS Server Started. Waiting for client connection...");

                // Close the input and output streams
                dis.close();
                dos.close();

                // Close the existing socket
                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}