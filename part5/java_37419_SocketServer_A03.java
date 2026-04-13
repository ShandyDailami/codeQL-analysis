import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_37419_SocketServer_A03 {
    private static final int NTH_THREAD = 10;
    private static final int PORT = 9876;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NTH_THREAD);
        try (ServerSocket server = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"))) {
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client here, for simplicity we will not do anything
        }
    }
}