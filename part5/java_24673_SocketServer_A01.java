import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_24673_SocketServer_A01 {
    private static final String CLIENT_CERT_PATH = "/path/to/client-cert.pem";
    private static final String KEY_STORE_PATH = "/path/to/key-store.jks";
    private static final String KEY_STORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, null, null, null);

            serverSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEY_STORE_PATH), KEY_STORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKeyManagerFactory");
            keyManagerFactory.init(keyStore, KEY_STORE_PASSWORD.toCharArray());

            SSLServerSocket server = (SSLServerSocket) serverSocket.accept();
            server.setEnabledCipherSuites(server.getSupportedCipherSuites());
            server.setEnabledProtocols(server.getSupportedProtocols());

            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(keyManagerFactory, null, null);

            SSLSocket clientSocket = (SSLSocket) sslContext.getSocket((Socket) server.getRemoteSocket());
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send a message to the client
            out.println("Hello, client!");
            // Read the message from the client
            String message = in.readLine();
            System.out.println("Server received: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}