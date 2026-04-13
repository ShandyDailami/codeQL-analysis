import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_25239_SocketServer_A01 {
    private final ExecutorService pool = Executors.newFixedThreadPool(10);
    private final ServerSocket serverSocket;

    public java_25239_SocketServer_A01(int port) throws IOException {
        serverSocket = new ServerSocket(port, 0, InetAddress.getByName("localhost"));
    }

    public void start() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            pool.submit(new ClientHandler(clientSocket));
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(8080).start();
    }

    private class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_25239_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client communication securely
        }
    }
}