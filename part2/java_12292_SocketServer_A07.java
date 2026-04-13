import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class java_12292_SocketServer_A07 {

    private final int port;

    public java_12292_SocketServer_A07(int port) {
        this.port = port;
    }

    public void startServer() throws Exception {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream("/keystore.jks"), "password".toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);

        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port,
                null,
                trustManagerFactory,
                KeyStore.getDefaultType(),
                "password".toCharArray());

        System.out.println("Server started");
        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setNeedClientAuth(true);
            System.out.println("Client Connected");

            Thread thread = new Thread(new SocketHandler(clientSocket));
            thread.start();
        }
    }

    private static class SocketHandler implements Runnable {
        private Socket socket;

        public java_12292_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: handle client communication here
        }
    }

    public static void main(String[] args) {
        try {
            new SecureServer(8443).startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}