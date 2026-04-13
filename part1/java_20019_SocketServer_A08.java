import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_20019_SocketServer_A08 {

    private static final int PORT = 4445;
    private static final int NUM_THREADS = 10;

    private ExecutorService executor;

    public java_20019_SocketServer_A08() {
        executor = Executors.newFixedThreadPool(NUM_THREADS);
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket client = server.accept();
            System.out.println("Accepted connection from " + client.getRemoteSocketAddress());
            executor.execute(new ClientHandler(client));
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_20019_SocketServer_A08(Socket socket) {
            clientSocket = socket;
        }

        public void run() {
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Hello, Client!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer().start();
    }
}