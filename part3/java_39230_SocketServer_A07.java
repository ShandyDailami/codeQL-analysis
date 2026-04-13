import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_39230_SocketServer_A07 {
    private static final String SSL_PROTOCOL = "SSL";
    private static final String SERVER_SOFTWARE = "Secure Server";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            KeyStore keystore = KeyStore.getInstance("JKS");
            char[] password = "password".toCharArray();

            // Load the key store
            InputStream inputStream = SecureSocketServer.class.getResourceAsStream("/keystore.jks");
            keystore.load(inputStream, password);

            // Set the key store provider
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKeyStore");
            keyManagerFactory.init(keystore, password);

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(keystore);

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyStore(keystore);
            sslServerSocketFactory.setKeyManagerFactory(keyManagerFactory);
            sslServerSocketFactory.setTrustManagerFactory(trustManagerFactory);

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8001);

            while (true) {
                clientSocket = serverSocket.accept();

                System.out.println("Connection accepted from " + clientSocket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Send a greeting message
                out.writeUTF("Hello Client, You are connected to the secure server!");
                out.flush();

                String message = in.readUTF();
                System.out.println("Message from Client: " + message);

                clientSocket.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}