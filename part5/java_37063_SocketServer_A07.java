import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_37063_SocketServer_A07 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        try (SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT, (SSLServerSocket) null, InetAddress.getByName("localhost"))) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("New client connected!");
                executorService.execute(new SocketHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}

class SocketHandler implements Runnable {

    private SSLSocket socket;

    public java_37063_SocketServer_A07(SSLSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client socket here, for example, by reading and writing data.
    }
}