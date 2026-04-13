import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_01932_SocketServer_A07 {
    private static final int PORT = 12345;
    private static final int THREADS = 5;
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetAddress.Loopback(), PORT);

        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            Handler handler = new Handler(socket, executorService, PASSWORD);
            handler.start();
        }
    }
}