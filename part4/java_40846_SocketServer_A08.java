import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_40846_SocketServer_A08 {
    private static final int PORT = 8080;
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "yourpassword";
    private static final String KEY_PASSWORD = "keypassword";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (SSLServerSocket serverSocket = (SSLServerSocket) SSLServerSocketFactory
            .createServerSocket(PORT, null, KEYSTORE_LOCATION, KEYSTORE_PASSWORD)
            .createContext("TLSv1.2", null)) {
            System.out.println("Server started. Listening for client on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                executorService.execute(new SocketHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class SocketHandler implements Runnable {
        private Socket socket;

        public java_40846_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle socket operations here
        }
    }
}