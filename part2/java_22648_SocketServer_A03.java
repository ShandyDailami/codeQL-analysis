import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_22648_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final String SSL_KEYSTORE_FILENAME = "mykeystore.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "mypassword";
    private static final String SSL_TRUSTSTORE_FILENAME = "mytruststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "mypassword";
    private static final String SSL_CERTIFICATE_ALIAS = "mycert";

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

        sslServerSocket.setNeedClientAuthentication(true);
        sslServerSocket.setDegraded(true);

        System.out.println("Listening for client connections on port " + PORT);

        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            executorService.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        private final Socket socket;

        SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle request here
        }
    }
}