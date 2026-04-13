import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_07014_SocketServer_A03 {
    private static final int PORT = 8888;
    private static SSLServerSocket sslServerSocket;
    private static ServerSocket serverSocket;
    private static SSLContext sslContext;
    private static ExecutorService executorService;

    public static void main(String[] args) {
        initialize();
        acceptClients();
    }

    private static void initialize() {
        try {
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket = new ServerSocket();

            executorService = Executors.newFixedThreadPool(5);

            System.out.println("Server started on port: " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static void acceptClients() {
        while (true) {
            try {
                Socket clientSocket = sslServerSocket.accept();
                System.out.println("Client connected");

                executorService.execute(new SocketHandler(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}