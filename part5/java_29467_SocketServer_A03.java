import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_29467_SocketServer_A03 {
    private static final int PORT = 4445;
    private static ExecutorService executor;

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            executor = Executors.newFixedThreadPool(10);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                ClientHandler clientHandler = new ClientHandler(socket);
                executor.execute(clientHandler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                    executor.shutdown();
                    System.out.println("Server stopped");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}