import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_30002_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        // Create SSLServerSocket
        SSLServerSocket serverSocket = null;

        try {
            // Load the certificate and key
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuthentication(true);

            // Setup SSLContext
            KeyStore keyStore = KeyStore.getInstance("JKS");
            InputStream keystoreStream = new FileInputStream("server.jks");
            keyStore.load(keystoreStream, "password".toCharArray());
            keyStore.store(null, "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, null);
            serverSocket.setSSLContext(sslContext);

            // Accept client connections
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");

                // Set up input and output streams
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Echo back any received message
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.writeBytes(message + "\n");
                }

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
        }
    }
}