import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_24555_SocketServer_A03 {
    private static final int PORT = 8888;
    private static final int POOL_SIZE = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

        // Create server socket
        try (SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Handle each connection in a separate thread
                executorService.execute(new SocketHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketHandler implements Runnable {
        private final Socket socket;

        SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get the input and output streams
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();

                // Now you can write and read data
                // ...

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}