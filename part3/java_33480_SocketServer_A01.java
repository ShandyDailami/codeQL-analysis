import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_33480_SocketServer_A01 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            // Setup the server socket
            serverSocket = new ServerSocket(PORT);

            // Create a KeyStore and KeyManager that includes certificates for client connections
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("client.jks"), "password".toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, "password".toCharArray());

            // Setup SSL Server Socket
            sslServerSocket = (SSLServerSocket) serverSocket;
            sslServerSocket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory, null, null);

            // Accept and secure a connection
            socket = sslServerSocket.accept();
            socket.setSSLSocket(sslServerSocket);
            SSLSocket sslSocket = (SSLSocket) socket;
            sslSocket.setNeedClientAuth(true);

            // Handle the connection
            OutputStream outputStream = sslSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("Hello, Client!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the socket
            if (socket != null) socket.close();
            if (serverSocket != null) serverSocket.close();
        }
    }
}