import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_31386_SocketServer_A07 {

    private final Executor executor;
    private final SSLServerSocket sslServerSocket;

    public java_31386_SocketServer_A07(int port, int backlog) throws IOException {
        this.executor = Executors.newCachedThreadPool();
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        this.sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port, backlog);
        this.sslServerSocket.setNeedClientAuth(true);
        this.sslServerSocket.setReuseAddress(true);
    }

    public void start() throws IOException {
        System.out.println("Starting SSL Server on port " + sslServerSocket.getLocalPort());
        while (true) {
            executor.execute(new SSLHandler(sslServerSocket.accept()));
        }
    }

    private static final class SSLHandler implements Runnable {

        private final SSLServerSocket sslServerSocket;

        public java_31386_SocketServer_A07(SSLServerSocket sslServerSocket) {
            this.sslServerSocket = sslServerSocket;
        }

        @Override
        public void run() {
            try {
                SSLConnection sslConnection = (SSLConnection) sslServerSocket.accept();
                // Handle SSLConnection here
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureServer(8443, 100).start();
    }
}