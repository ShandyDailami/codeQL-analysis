import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_06876_SocketServer_A08 {
    private final int port;
    private final ExecutorService executorService;

    public java_06876_SocketServer_A08(int port, int poolSize) {
        this.port = port;
        this.executorService = Executors.newFixedThreadPool(poolSize);
    }

    public void start() {
        try (SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(port)) {
            serverSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, null);
            serverSocket.setSSLContext(sslContext);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.execute(new SocketHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_06876_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Handle client socket here
            } finally {
                socket.close();
            }
        }
    }

    private static class TrustAnyTrustManager implements X509TrustManager {
        public java_06876_SocketServer_A08() {}

        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {}
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {}
        public X509Certificate[] getAcceptedIssuers() { return null; }
    }
}