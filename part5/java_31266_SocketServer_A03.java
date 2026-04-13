import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_31266_SocketServer_A03 {

    private static final int PORT = 8080;
    private static final String CLIENT_ID = "Client";
    private static final String SECRET_KEY = "Key";

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        try (SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT)) {
            while (true) {
                try (SSLSocket socket = (SSLSocket) serverSocket.accept()) {
                    socket.setEnabledCipherSuites(socket.getSupportedCipherSuites());
                    System.out.println(CLIENT_ID + " connected!");
                    Handler handler = new Handler(socket, SECRET_KEY);
                    executor.execute(handler);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class Handler implements Runnable {
        private final Socket socket;
        private final String secretKey;

        public java_31266_SocketServer_A03(Socket socket, String secretKey) {
            this.socket = socket;
            this.secretKey = secretKey;
        }

        @Override
        public void run() {
            // Handling the request
            try {
                socket.getInputStream().read();
                System.out.println("Hello World");
            } catch (IOException e) {
                e.printStackTrace();
            }
            socket.close();
        }
    }
}