import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37342_SocketServer_A08 {
    private static final String SSL_ENABLED = "SSL_ENABLED";

    public static void main(String[] args) throws Exception {
        String keyStorePath = args[0];
        char[] keyStorePassword = args[1].toCharArray();
        SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory(keyStorePath, keyStorePassword);

        ServerSocket serverSocket = new SSLServerSocket(sslServerSocketFactory, 10000);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) clientSocket.createInstance("TLSv1.2");
            sslSocket.setNeedClientAuth(true);
            sslSocket.setEnabledCipherSuites(new String[]{"TLSv1.2", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLSv1.2"});
            sslSocket.setEnabledExtensions(new String[]{"SSL_SESSION_TICKET"});
            new Handler(sslSocket).start();
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory(String keyStorePath, char[] keyStorePassword) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = null;
            SSLContext sslContext = getSSLContext(keyStorePath, keyStorePassword);
            sslServerSocketFactory = sslContext.getServerSocketFactory();
            return sslServerSocketFactory;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SSLContext getSSLContext(String keyStorePath, char[] keyStorePassword) throws Exception {
        SSLContext sslContext = null;
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(10000);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream(keyStorePath), keyStorePassword);
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, keyStorePassword);
            sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(keyManagerFactory, null);
            sslServerSocket.setNeedClientAuth(true);
            return sslContext;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class Handler extends Thread {
        private final SSLSocket socket;

        public java_37342_SocketServer_A08(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}