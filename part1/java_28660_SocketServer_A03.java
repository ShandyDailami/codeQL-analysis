import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_28660_SocketServer_A03 {
    private static SSLServerSocket serverSocket;
    private static SSLSocket socket;

    public static void main(String[] args) {
        System.out.println("Starting SSL Server...");

        try {
            // Create a KeyStore and a TrustStore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            TrustStore trustStore = TrustStore.getInstance("JKS");

            // Create a KeyStore and a TrustStore using a default algorithm
            keyStore.load(new FileInputStream("path/to/your/keystore"), "password".toCharArray());
            trustStore.load(new FileInputStream("path/to/your/truststore"), "password".toCharArray());

            // Create a SSLServerSocket and accept a client
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setKeyStore(keyStore);
            serverSocket.setTrustStore(trustStore);
            socket = (SSLSocket) serverSocket.accept();
            socket.startHandshake();

            // Get the SSLSocketInputStream and SSLSocketOutputStream
            SSLSocketInputStream sslInput = new SSLSocketInputStream(socket.getInputStream());
            SSLSocketOutputStream sslOutput = new SSLSocketOutputStream(socket.getOutputStream());

            // Send a request
            sslOutput.write("Hello, Client!".getBytes());
            sslOutput.flush();

            // Get the server's response
            byte[] buffer = new byte[1024];
            int bytesRead = sslInput.read(buffer);
            System.out.println("Server response: " + new String(buffer, 0, bytesRead));

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}