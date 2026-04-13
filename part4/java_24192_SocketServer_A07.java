import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_24192_SocketServer_A07 {

    private static final String CLIENT_KEY_STORE = "client.keystore";
    private static final String CLIENT_KEY_STORE_PASSWORD = "password";
    private static final String SERVER_KEY_STORE = "server.keystore";
    private static final String SERVER_KEY_STORE_PASSWORD = "password";
    private static final String ALGORITHM = "SSLv3";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            KeyStore clientKeyStore = KeyStore.getInstance("JKS");
            clientKeyStore.load(new FileInputStream(CLIENT_KEY_STORE), CLIENT_KEY_STORE_PASSWORD.toCharArray());

            KeyStore serverKeyStore = KeyStore.getInstance("JKS");
            serverKeyStore.load(new FileInputStream(SERVER_KEY_STORE), SERVER_KEY_STORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyFactory.getDefaultAlgorithm());
            keyManagerFactory.init(clientKeyStore, CLIENT_KEY_STORE_PASSWORD.toCharArray());

            KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(serverKeyStore);

            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

            SSLContext sslContext = SSLContext.getInstance(ALGORITHM);
            sslContext.init(keyManagers, trustManagers, null);

            serverSocket = (SSLServerSocket) sslContext.getServerSocket(8090);

            while (true) {
                clientSocket = serverSocket.accept();

                SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(clientSocket);

                OutputStream out = sslSocket.getOutputStream();
                InputStream in = sslSocket.getInputStream();

                PrintWriter outWriter = new PrintWriter(new OutputStreamWriter(out), true);
                BufferedReader inReader = new BufferedReader(new InputStreamReader(in));

                String clientMessage;
                while ((clientMessage = inReader.readLine()) != null) {
                    outWriter.println("Received: " + clientMessage);
                }
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (clientSocket != null) clientSocket.close();
        }
    }
}