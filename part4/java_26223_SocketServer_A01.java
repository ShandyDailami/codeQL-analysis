import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_26223_SocketServer_A01 {

    private static final int PORT = 9000;
    private static final int THREADS = 5;
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setReuseAddress(true);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");

                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();

                executorService.execute(new Runnable() {
                    public void run() {
                        handleRequest(input, output);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static void handleRequest(InputStream input, OutputStream output) {
        // handle request, you can use SSLSocket here
    }
}