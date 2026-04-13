import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.PasswordAuthentication;
import javax.net.ssl.TrustManagerFactory;

public class java_21427_SocketServer_A07 {
    static class SocketThread extends Thread {
        private Socket socket;
        private boolean authenticated = false;

        public java_21427_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                SSLServerSocket sslServerSocket = (SSLServerSocket) socket;
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                System.out.println("Client connected: " + sslSocket.getRemoteSocketAddress());

                KeyStore keyStore = KeyStore.getInstance("JKS");
                char[] password = "password".toCharArray();
                keyStore.load(getClass().getResourceAsStream("/client.jks"), password);

                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, password);
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);

                sslSocket.setNeedClientAuth(true);
                sslSocket.setCertificateTrustManager(trustManagerFactory);

                Key key = keyManagerFactory.getKey("key");
                sslSocket.setKeyAndCertificate(key, trustManagerFactory.getTrustManager());

                PasswordAuthentication auth = new PasswordAuthentication("user", "password".toCharArray());
                sslSocket.setAuthentication(auth);

                // Here you would usually perform the authentication and send a response.
                // For the sake of simplicity, this example just verifies the client is authenticated.
                authenticated = sslSocket.isClientAuthenticated();

                sslSocket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public boolean isAuthenticated() {
            return authenticated;
        }
    }

    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        ServerSocket serverSocket = new ServerSocket(8080, 0, address);

        serverSocket.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("SSL");

        sslContext.init(KeyManagerFactory.getDefaultAlgorithm(), TrustManagerFactory.getDefaultAlgorithm(), null);
        serverSocket.setSSLContext(sslContext);

        while (true) {
            Socket socket = serverSocket.accept();
            SocketThread thread = new SocketThread(socket);
            thread.start();
        }
    }
}