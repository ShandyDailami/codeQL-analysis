import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_37517_SocketServer_A03 {
    private static final int PORT = 8888;
    private static final int MAX_POOL_SIZE = 10;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_POOL_SIZE);

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
        System.out.println("Server started.");

        while (true) {
            final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected.");
            executorService.execute(new SocketTask(clientSocket));
        }
    }

    private static class SocketTask implements Runnable {
        private final Socket socket;

        public java_37517_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle socket communication here
        }
    }
}