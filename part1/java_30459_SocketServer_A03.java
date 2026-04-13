import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_30459_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setEnabledRoots(true);
            sslServerSocket.setNeedClientAuth(true);

            SSLContext sslContext = sslServerSocket.getSSLContext();
            KeyStore keyStore = sslContext.getKeyStore();
            TrustManagerFactory trustManagerFactory = sslContext.getTrustManagerFactory();

            KeyStore trustStore = sslContext.getTrustStore();
            KeyManagerFactory keyManagerFactory = sslContext.getKeyManagerFactory();

            // Load the certificate and private key
            trustStore.load(new FileInputStream("truststore.jks"), "truststorepassword".toCharArray());
            keyStore.load(new FileInputStream("keystore.jks"), "keystorepassword".toCharArray());

            // Set up the trust managers
            sslServerSocket.setTrustManager(trustManagerFactory.getTrustManagers());

            System.out.println("Waiting for client connection...");

            // Accept a client connection
            socket = sslServerSocket.accept();
            System.out.println("Client connection established!");

            // Send and receive HTTP request and response
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // TODO: Implement your logic here

            sslServerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}