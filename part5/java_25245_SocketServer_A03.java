import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_25245_SocketServer_A03 {

    private static final int PORT = 8080;
    private static final int THREADS = 5;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
        serverSocket.setNeedClientAuth(true);

        while (true) {
            final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            executor.execute(new SocketHandler(clientSocket));
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_25245_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle the socket communication here
        }
    }
}