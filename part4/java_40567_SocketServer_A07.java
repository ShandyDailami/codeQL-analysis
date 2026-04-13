import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_40567_SocketServer_A07 {
    private static final int PORT = 8888;
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "your_password";
    private static final String TRUSTSTORE_LOCATION = "/path/to/your/truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_password";

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

        sslServerSocket.setNeedClientAuth(true);

        sslServerSocket.getCertificateMap().putAll(KeyStoreUtil.loadKeyStore(KEYSTORE_LOCATION, KEYSTORE_PASSWORD));
        sslServerSocket.getTrustManager().setTrustAllCertificates(KeyStoreUtil.loadTrustStore(TRUSTSTORE_LOCATION, TRUSTSTORE_PASSWORD));

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            executorService.execute(new SocketHandler(clientSocket));
        }
    }

    private static class SocketHandler implements Runnable {
        private Socket socket;

        public java_40567_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello World!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}