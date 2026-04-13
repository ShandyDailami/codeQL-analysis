import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;

public class java_03038_SocketServer_A03 {

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            // Load the keystore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            InputStream inputStream = SocketServer.class.getResourceAsStream("/server.jks");
            keyStore.load(inputStream, "password".toCharArray());

            // Initialize the SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, null);

            // Initialize the serverSocket for SSL
            serverSocket = (SSLServerSocket) sslContext.getServerSocket(4444);
            serverSocket.setNeedClientAuth(true);

        } catch (IOException | CertificateException | java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return;
        }

        // Accept client connections
        while (true) {
            try {
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected!");

                // Get the output stream
                OutputStream outputStream = sslSocket.getOutputStream();
                // Write a response
                outputStream.write("Hello, Client!".getBytes());
                sslSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}