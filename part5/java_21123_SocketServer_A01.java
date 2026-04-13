import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_21123_SocketServer_A01 {
    private static final String SSL_KEYSTORE_LOCATION = "/path/to/keystore";
    private static final String SSL_KEYSTORE_PASSWORD = "keystorepassword";
    private static final String SSL_KEY_PASSWORD = "keypassword";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(9001);
            serverSocket.setNeedClientAuthentication(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(SSL_KEYSTORE_LOCATION), SSL_KEYSTORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKSAPI");
            keyManagerFactory.init(keyStore, SSL_KEY_PASSWORD.toCharArray());

            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.createChannel().getUnderlying();
            sslServerSocket.setKeyManager(keyManagerFactory);

            while (true) {
                Socket clientSocket = sslServerSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Client says: " + clientMessage);
               
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("Server says: Hello, client!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}