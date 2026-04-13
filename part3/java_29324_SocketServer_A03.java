import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_29324_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        // Create a KeyStore and KeyStorePassword
        KeyStore keyStore = KeyStore.getInstance("JKS");
        KeyStorePassword keyStorePassword = new KeyStorePassword("password");

        // Initialize the key store
        keyStore.load(new FileInputStream("server.jks"), keyStorePassword.getPassword());

        // Setup the SSL context
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) sslServerSocket.getServerSocketFactory();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        // Setup SSLSocketFactory
        SSLSocketFactory sslSocketFactory = sslServerSocket.getSocketFactory();

        while (true) {
            sslSocket = (SSLSocket) sslSocketFactory.createSocket(sslServerSocket.getLocalSocketAddress());

            sslSocket.startHandshake();

            // Output SSL certificate
            SSLCertificate cert = sslSocket.getLocalCertificate();
            System.out.println(cert.toString());

            // Input stream for reading from SSL socket
            InputStream inputStream = sslSocket.getInputStream();

            // Output stream for writing to SSL socket
            OutputStream outputStream = sslSocket.getOutputStream();

            // Read and write operations
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

            // For testing purposes, read and write from and to the client
            String clientMessage = reader.readLine();
            writer.write("Server received: " + clientMessage);
            writer.newLine();
            writer.flush();

            sslSocket.close();
        }
    }
}