import javax.net.ssl.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_14813_SocketServer_A08 {

    private static final int DEFAULT_PORT = 12345;
    private static final SSLServerSocket DEFAULT_SERVER_SOCKET = (SSLServerSocket) new SSLServerSocket(DEFAULT_PORT);

    public static void main(String[] args) throws IOException {

        ExecutorService executor = Executors.newCachedThreadPool();

        while (true) {
            final Socket clientSocket = DEFAULT_SERVER_SOCKET.accept();
            System.out.println("Accepted new connection from: " + clientSocket.getRemoteSocketAddress());
            executor.execute(new SocketHandler(clientSocket));
        }
    }

    private static class SocketHandler implements Runnable {

        private final Socket socket;

        SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (OutputStream outputStream = socket.getOutputStream()) {
                SSLSocket sslSocket = (SSLSocket) socket;
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, null);
                sslSocket.setNeedClientAuth(true);
                sslSocket.setUseClientMode(true);
                sslSocket.setSSLContext(sslContext);
                outputStream.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class TrustAllCerts implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}