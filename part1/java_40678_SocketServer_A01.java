import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_40678_SocketServer_A01 {
    private static final int MAX_CLIENTS = 5; // maximum clients
    private static final int PORT = 60000; // port number

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_CLIENTS);
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " connected");
                ClientHandler clientHandler = new ClientHandler(clientSocket, executor);
                executor.execute(clientHandler);
                if (executor.size() >= MAX_CLIENTS) {
                    System.out.println("No room for new clients, connection refused");
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final ExecutorService executor;

    public java_40678_SocketServer_A01(Socket clientSocket, ExecutorService executor) {
        this.clientSocket = clientSocket;
        this.executor = executor;
    }

    @Override
    public void run() {
        // handle client connection and disconnection
    }
}