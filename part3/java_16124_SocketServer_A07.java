import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_16124_SocketServer_A07 {
    private static final int PORT = 8080;

    private static ServerSocket serverSocket;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(PORT);
        executor = Executors.newFixedThreadPool(5);

        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getInetAddress() + " has connected!");

            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_16124_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle client communication here
            // this will be non-blocking
        }
    }
}