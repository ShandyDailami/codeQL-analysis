import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_39086_SocketServer_A07 {

    private static final int PORT = 8443;
    private static final String KEYSTORE_LOCATION = "path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "yourpassword";
    private static final String TRUSTSTORE_LOCATION = "path/to/your/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "yourpassword";

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

        sslServerSocket.setNeedClientAuth(true);

        while (true) {
            Socket clientSocket = sslServerSocket.accept();
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
            // handle client socket here
        }
    }
}