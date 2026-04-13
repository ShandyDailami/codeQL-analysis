import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_30392_SocketServer_A03 {

    private static final int PORT = 8080;
    private static final int CORE_POOL_SIZE = 10;
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(CORE_POOL_SIZE);

    public static void main(String[] args) throws Exception {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                threadPool.execute(new ClientHandler(socket));
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_30392_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) != -1) {
                    out.write(buffer, 0, length);
                    out.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}