import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_04625_SocketServer_A03 {

    private static final int PORT = 8080;
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password_for_your_keystore";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "password_for_your_truststore";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT)) {
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());
                ClientHandler handler = new ClientHandler(clientSocket);
                executorService.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_04625_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                out.println("Hello, client!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}