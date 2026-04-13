import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_10475_SocketServer_A01 {

    private static final int PORT = 8080;
    private static final int POOL_SIZE = 5;
    private static final ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(POOL_SIZE);
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
                Handler handler = new Handler(clientSocket);
                executorService.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); }
                catch (IOException e) { e.printStackTrace(); }
            }
        }
    }

    private static class Handler implements Runnable {
        private Socket socket;

        public java_10475_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle the client request here
        }
    }
}