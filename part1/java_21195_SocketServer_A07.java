import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_21195_SocketServer_A07 {
    private static final int PORT = 9000;
    private static final int CORE_POOL_SIZE = 10;
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(CORE_POOL_SIZE);

    public static void main(String[] args) {
        System.out.println("Starting Socket Server on port " + PORT + "...");

        try (SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT, null, null, InetAddress.getByName("localhost"))) {
            while (true) {
                final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Handle client communication...
                        } finally {
                            clientSocket.close();
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}