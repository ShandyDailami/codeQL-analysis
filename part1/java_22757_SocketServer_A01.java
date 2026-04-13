import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_22757_SocketServer_A01 {

    private static final int PORT = 8443;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(CPU_COUNT * 2);

    public static void main(String[] args) {
        (new SocketServer()).start();
    }

    private void start() {
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            serverSocket.accept();
            serverSocket.setNeedClientAuth(true);
            serverSocket.setEnabledCipherSuites(new String[]{"TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"});
            serverSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());
                threadPool.execute(new ConnectionHandler(socket, sslContext));
            }
        } catch (SSLException e) {
            e.printStackTrace();
        }
    }

    private class ConnectionHandler implements Runnable {
        private final Socket socket;
        private final SSLContext sslContext;

        ConnectionHandler(Socket socket, SSLContext sslContext) {
            this.socket = socket;
            this.sslContext = sslContext;
        }

        @Override
        public void run() {
            try {
                SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);
                sslSocket.setNeedClientAuth(true);
                sslSocket.setEnabledCipherSuites(new String[]{"TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"});
                sslSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
                // handle the connection...
            } catch (SSLException e) {
                e.printStackTrace();
            }
        }
    }
}