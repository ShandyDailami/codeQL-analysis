import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.*;

public class java_36145_SocketServer_A03 {

    private final static int PORT = 8080;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        sslServerSocket.setNeedClientAuthentication(true);

        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, new TrustManager[] {new InsecureTrustManager()}, null);
        sslServerSocket.setSSLSocketFactory(sslContext.getSocketFactory());

        System.out.println("Server is listening on port " + PORT + "...");

        while (true) {
            final SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            threadPool.execute(new SocketTask(clientSocket));
        }
    }

    private static class SocketTask implements Runnable {
        private final SSLSocket socket;

        SocketTask(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle client request
        }
    }

    private static class InsecureTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}