import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_38433_SocketServer_A01 {
    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        Socket client = null;

        try {
            // Create a SSL Server Socket.
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(4444);
            serverSocket.setNeedClientAuth(true);

            // Load a client keystore
            KeyStore clientKeystore = KeyStore.getInstance("JKS");
            clientKeystore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());

            // Setup a KeyManagerFactory with the client keystore
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKeyStore");
            keyManagerFactory.init(clientKeystore, CLIENT_KEYSTORE_PASSWORD.toCharArray());

            // Setup a TrustManagerFactory with the client keystore
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(clientKeystore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory, trustManagerFactory, new java.security.SecureRandom());

            // Accept a client connection
            socket = (SSLServerSocket) serverSocket.accept();
            socket.setNeedClientAuth(true);
            client = socket.accept();

            // Setup a SSLSocket with the SSLContext
            SSLSocket sslSocket = (SSLSocket) sslContext.wrapSocket(client);

            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                writer.println("Message received");
            }

            sslSocket.close();
        } finally {
            if (socket != null) socket.close();
            if (client != null) client.close();
        }
    }
}