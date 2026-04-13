import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_01192_SocketServer_A07 {

    private static final String CLIENT_KEY_STORE = "client.keystore";
    private static final String CLIENT_KEY_STORE_PASSWORD = "password";
    private static final String SERVER_KEY_STORE = "server.keystore";
    private static final String SERVER_KEY_STORE_PASSWORD = "password";
    private static final String ALGORITHM = "SunEC";

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = null;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Create a SSL Server Socket
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
            sslServerSocket.setNeedClientAuth(true);

            System.out.println("Waiting for client authentication...");

            // Accept client connection
            Socket socket = sslServerSocket.accept();
            System.out.println("Client accepted.");

            // Authenticate the client
            socket.getChannel().doHandshake();
            System.out.println("Client authenticated.");

            // Create a new thread for each client
            executorService.execute(new SocketHandler(socket));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Shutdown executor service
            executorService.shutdown();
            sslServerSocket.close();
        }
    }

    static class SocketHandler implements Runnable {

        private Socket socket;

        public java_01192_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Implement server code here
        }
    }
}