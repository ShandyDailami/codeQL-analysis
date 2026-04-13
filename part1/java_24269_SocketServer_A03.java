import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_24269_SocketServer_A03 {
    private static final String KEYSTORE = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            sslServerSocket.setNeedClientAuth(true);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream(KEYSTORE), KEYSTORE_PASSWORD.toCharArray());

            SSLServerCertificateExtension defaultSslServerCertificateExtension = new SSLServerCertificateExtension();
            sslServerSocket.setExtensions(new SSLServerSocketExtension[] { defaultSslServerCertificateExtension });

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, KEY_PASSWORD.toCharArray(), new java.security.SecureRandom());
            sslServerSocket.setSSLContext(sslContext);

            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
                new SecureServerThread(socket).start();
            }
        } finally {
            sslServerSocket.close();
        }
    }
}

class SecureServerThread extends Thread {
    private final Socket socket;

    public java_24269_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Now you can read and write data encrypted using SSL/TLS
            // ...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}