import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_06028_SocketServer_A08 {
    private static final int PORT = 8443;
    private static final SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(new InetSocketAddress(PORT), 100, executorService)) {
            sslServerSocket.setNeedClientAuth(true);
            while (true) {
                executorService.execute(new SocketHandler(sslServerSocket.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    static class SocketHandler implements Runnable {
        private final SSLServerSocket socket;

        SocketHandler(SSLServerSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle client connection here
        }
    }
}