import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_05271_SocketServer_A03 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password_of_your_keystore";
    private static final String KEY_PASSWORD = "password_for_your_key";
    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());
            sslContext.init(keyStore, KEY_PASSWORD.toCharArray(), new java.security.cert.Certificate[]{});

            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) sslContext.wrapSocket(socket);
                System.out.println("Connection accepted from " + sslSocket.getRemoteSocketAddress());
                OutputStream out = sslSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello, Client!");
                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}