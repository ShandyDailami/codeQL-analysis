import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_36529_SocketServer_A07 {
    private static final String SSL_KEYSTORE = "path_to_your_keystore.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String SSL_TRUSTSTORE = "path_to_your_truststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuthentication(true);

            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream(SSL_KEYSTORE), SSL_KEYSTORE_PASSWORD.toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, null);

            sslServerSocket.setSSLContext(sslContext);

            while (true) {
                Socket socket = sslServerSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.createChannel();
                sslSocket.setNeedClientAuthentication(true);

                // Here you can use the SSLSocket to send and receive data
                // For now, we just accept and echo back the data
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println(message);
                }
            }
        } finally {
            sslServerSocket.close();
        }
    }
}