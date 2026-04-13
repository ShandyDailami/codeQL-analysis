import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_00974_SocketServer_A07 {

    private static final int PORT = 12345;
    private static final int THREADS = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_00974_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // here we would usually perform SSL/TLS handshake and then authentication
                // for this example we'll use a very simple custom authentication
                socket.getChannel().write(ByteBuffer.wrap("Hello, client!".getBytes()));
                socket.getChannel().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}