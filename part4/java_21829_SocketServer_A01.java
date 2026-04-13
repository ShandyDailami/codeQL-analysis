import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_21829_SocketServer_A01 {
    private static final int PORT = 8080;
    private static final int MAX_POOL_SIZE = 10;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_POOL_SIZE);
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());
            executorService.execute(new ClientHandler(socket));
        }
    }
}

class ClientHandler implements Runnable {
    private static final int INACTIVITY_TIMEOUT = 5; // in seconds

    private Socket socket;
    private int inactivityTimeout;

    public java_21829_SocketServer_A01(Socket socket) {
        this.socket = socket;
        this.inactivityTimeout = INACTIVITY_TIMEOUT;
    }

    @Override
    public void run() {
        // Incoming connection, start communication here
        // ...

        // After inactivity, close the connection
        new Thread(() -> {
            inactivityTimeout = INACTIVITY_TIMEOUT;
        }).start();
    }
}