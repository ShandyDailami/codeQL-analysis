import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

public class java_25369_SocketServer_A01 {

    private static final int PORT = 8080;
    private static final int CORE_POOL_SIZE = 10;
    private static final int MAXIMUM_POOL_SIZE = 20;
    private static final int KEEP_ALIVE_TIME = 5000;

    private static ThreadPoolExecutor executor;

    public static void main(String[] args) throws IOException {
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(CORE_POOL_SIZE);

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected at " + socket.getRemoteSocketAddress());

            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_25369_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Here you can add your logic to handle the client's request
            // For now, we will simulate a request by printing a message
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = reader.readLine();
                System.out.println("Received message from client: " + message);

                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Hello, client, you are connected to the server!");
            } catch (IOException e) {
                System.out.println("Failed to handle client request: " + e.getMessage());
            }
        }
    }
}