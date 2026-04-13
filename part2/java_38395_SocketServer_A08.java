import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_38395_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Set up SSLContext
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(9999);
            serverSocket.setNeedClientAuth(true);

            // Enable client authentication
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("client.jks"), "password".toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunPKCS11");
            keyManagerFactory.init(keyStore, "password".toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(keyStore);

            // Set up SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory, trustManagerFactory, null);

            while (true) {
                // Wait for a client to connect
                clientSocket = (SSLSocket) serverSocket.accept();
                clientSocket.startHandshake();

                // Write out the handshake information
                System.out.println("Handshake completed: " + clientSocket.getHandshakeStatus());

                // Now we can read the data
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                }

                // Close the connection
                clientSocket.close();
            }
        } finally {
            serverSocket.close();
        }
    }
}