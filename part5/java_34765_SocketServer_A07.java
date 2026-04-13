import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_34765_SocketServer_A07 {
    private static final String CLIENT_ADDRESS = "127.0.0.1"; // replace with your client address
    private static final int PORT = 8443; // replace with your port

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT, InetAddress.getByName(CLIENT_ADDRESS));
            serverSocket.setNeedClientAuth(true);

            System.out.println("Server is listening on port " + PORT);

            while (true) {
                final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final SSLSocket socket;

        ClientHandler(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client here
        }
    }
}