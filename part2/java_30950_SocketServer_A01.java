import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_30950_SocketServer_A01 {

    private static final int PORT = 8443;
    private static final String KEYSTORE_LOCATION = "/path/to/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_LOCATION = "/path/to/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory =
            (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

        sslServerSocket.setNeedClientAuthentication(true);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("New client connected");
            executorService.execute(new SSLHandler(socket));
        }
    }

    private static class SSLHandler implements Runnable {

        private final Socket socket;

        SSLHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client request here
        }
    }
}