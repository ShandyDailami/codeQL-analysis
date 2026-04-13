import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_11809_SocketServer_A07 {
    private final static int PORT = 8888;
    private final static int CORE_POOL_SIZE = 10;
    private final static int MAX_POOL_SIZE = 10;
    private final static ExecutorService threadPool =
        Executors.newFixedThreadPool(CORE_POOL_SIZE);

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Client connected!");
                threadPool.execute(new SocketHandler(socket));
            }
        } finally {
            sslServerSocket.close();
            threadPool.shutdown();
        }
    }

    static class SocketHandler implements Runnable {
        private final Socket socket;

        SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: implement authentication and SSL socket operations here
        }
    }
}