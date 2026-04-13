import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_13329_SocketServer_A03 {

    private static final int PORT = 8080;
    private static final String SSL_TRUSTSTORE_LOCATION = "path-to-your-truststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "your-truststore-password";
    private static final String SSL_KEYSTORE_LOCATION = "path-to-your-keystore.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "your-keystore-password";
    private static final String SSL_KEY_ALIAS = "your-keystore-alias";

    private SSLServerSocket serverSocket;

    private void startServer() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);

            serverSocket.getSSLContext().setDefaultWant(
                    SSLServerSocketFactory.getDefaultWant(),
                    SSLServerSocketFactory.getDefaultWant());

            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Client " + client.getRemoteSocketAddress() + " connected.");
                executorService.execute(new ClientHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        server.startServer();
    }

    private class ClientHandler implements Runnable {

        private Socket client;

        public java_13329_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle client communication here.
        }
    }
}