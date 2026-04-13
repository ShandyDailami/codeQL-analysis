import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_26142_SocketServer_A07 {
    private static final String CLIENT_IP = "127.0.0.1";
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        sslServerSocket.setReuseAddress(true);

        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream keyStoreInputStream = new FileInputStream("keystore.jks");
        keyStore.load(keyStoreInputStream, "password".toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, "password".toCharArray());

        SSLServerSocket sslSocket = (SSLServerSocket) sslServerSocket.accept();
        SSLSocket clientSocket = (SSLSocket) sslSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        // Receive and send data
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Received: " + line);
            out.writeBytes(line + "\n");
        }

        clientSocket.close();
        sslServerSocket.close();
    }
}