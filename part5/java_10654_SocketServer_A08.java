import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_10654_SocketServer_A08 {

    private static final String KEYSTORE_PATH = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "yourpassword";
    private static final String KEY_PASSWORD = "keypassword";
    private static final int PORT = 8443;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;

        try {
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(new FileInputStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory =
                    KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keystore, KEY_PASSWORD.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            serverSocket = (SSLSocketServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String clientMessage;

                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received client: " + clientMessage);
                    out.println("Server: " + clientMessage);
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