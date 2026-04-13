import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.*;

public class java_17024_SocketServer_A07 {

    private static final int SERVER_PORT = 8080;
    private static final SSLServerSocket SERVER_SOCKET;
    private static final ExecutorService EXECUTOR_SERVICE;

    static {
        SSLServerSocket socket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            socket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT);
            socket.setNeedClientAuth(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new TrustAllCertsTrustManager()}, null);
            socket.setSSLContext(sslContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SERVER_SOCKET = socket;
        EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);
    }

    public static void main(String[] args) {
        System.out.println("Server is running on port " + SERVER_PORT + "...");
        Socket clientSocket = null;
        try {
            while ((clientSocket = SERVER_SOCKET.accept()) != null) {
                EXECUTOR_SERVICE.execute(new SocketHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (SERVER_SOCKET != null) {
                try {
                    SERVER_SOCKET.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            EXECUTOR_SERVICE.shutdown();
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_17024_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream(); OutputStream output = socket.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = input.read(buffer)) >= 0) {
                    output.write(buffer, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class TrustAllCertsTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }

        public boolean isServerTrusted(X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(X509Certificate[] certs) {
            return true;
        }

        public void invalidate() {
        }
    }
}