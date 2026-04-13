import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_21346_SocketServer_A07 {

    private static final int PORT = 5000;
    private static final int CORE_POOL_SIZE = 10;

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(CORE_POOL_SIZE);

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetAddress.getByName("localhost"), PORT);

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection from " + socket.getRemoteSocketAddress());

            executorService.execute(new SocketHandler(socket));
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_21346_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here you can handle the communication with the client.
        // For security-sensitive operations related to A07_AuthFailure, you should implement proper authentication and authorization.
    }
}