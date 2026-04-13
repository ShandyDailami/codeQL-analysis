import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_17088_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final int CORE_POOL_SIZE = 10;

    private ExecutorService executorService;
    private ServerSocket serverSocket;

    public java_17088_SocketServer_A03() {
        try {
            serverSocket = new ServerSocket(PORT);
            executorService = Executors.newFixedThreadPool(CORE_POOL_SIZE);
            System.out.println("Server started. Listening on port " + PORT + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
                executorService.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer().start();
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_17088_SocketServer_A03(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // handle client communication here
            // for example, read a message from the client and print it
            byte[] buffer = new byte[1024];
            int bytesRead = clientSocket.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received: " + message);

            // send a response back to the client
            String response = "Server received your message!";
            clientSocket.getOutputStream().write(response.getBytes());
            clientSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}