import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_04846_SocketServer_A03 {
    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String ALIAS = "alias";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            KeyStore clientKeystore = KeyStore.getInstance("JKS");
            clientKeystore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());
            KeyStore serverKeystore = KeyStore.getInstance("JKS");
            serverKeystore.load(new FileInputStream(SERVER_KEYSTORE), SERVER_KEYSTORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKS");
            keyManagerFactory.init(clientKeystore, CLIENT_KEYSTORE_PASSWORD.toCharArray());
            KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(serverKeystore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

            SSLServerSocketFactory sslServerSocketFactory = new SSLServerSocketFactory(trustManagers, keyManagers);
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println(message);
                }
            }
        } finally {
            serverSocket.close();
        }
    }
}