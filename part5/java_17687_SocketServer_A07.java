import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_17687_SocketServer_A07 {

    private static final int PORT = 8080;
    private static final String AUTH_FAILURE = "A07_AuthFailure";

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            System.err.println("Server failed to bind port " + PORT);
            System.exit(-1);
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                out.println(AUTH_FAILURE);
            } catch (IOException e) {
                socket.close();
            }
        }
    }
}