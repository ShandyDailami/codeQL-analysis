import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_20599_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            // Load the certificates and create a KeyStore
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);

            // Enable client certificate validation
            serverSocket.setNeedClientAuthentication(true);

            // Load the certificates
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("client.jks"), "password".toCharArray());

            // Configure SSLContext with the KeyStore
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, new java.security.SecureRandom());

            // Accept connections
            socket = (SSLSocket) serverSocket.accept();
            socket.setSSLSocket(socket);
            socket.setNeedClientAuthentication(true);

            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            socket = (SSLSocket) sslSocketFactory.createSocket(socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a message to the client
            out.writeBytes("Hello, Client!\n".getBytes());

            // Read the message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Close the connection
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (socket != null) socket.close();
        }
    }
}