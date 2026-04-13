import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_37060_SocketServer_A08 {
    private static final String SERVER_KEYSTORE_LOCATION = "/path/to/server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "serverkeystorepassword";
    private static final String CLIENT_KEYSTORE_LOCATION = "/path/to/client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "clientkeystorepassword";
    private static final String KEY_ALIAS = "keyalias";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            KeyStore serverKeystore = KeyStore.getInstance("JKS");
            serverKeystore.load(new FileInputStream(SERVER_KEYSTORE_LOCATION), SERVER_KEYSTORE_PASSWORD.toCharArray());

            KeyStore clientKeystore = KeyStore.getInstance("JKS");
            clientKeystore.load(new FileInputStream(CLIENT_KEYSTORE_LOCATION), CLIENT_KEYSTORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(serverKeystore, SERVER_KEYSTORE_PASSWORD.toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(clientKeystore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);

            sslSocket = (SSLSocket) sslContext.wrapSocket(sslServerSocket.accept());
            sslSocket.startHandshake();

            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                if (message.equals("exit")) {
                    writer.println("Bye!");
                    writer.flush();
                    break;
                } else {
                    writer.println("OK");
                    writer.flush();
                }
            }
        } finally {
            if (sslSocket != null) sslSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}