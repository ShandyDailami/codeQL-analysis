import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_33800_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final int THREADS = 5;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            ExecutorService executor = Executors.newFixedThreadPool(THREADS);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getRemoteSocketAddress() + " connected");

                Handler handler = new Handler(client);
                executor.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler implements Runnable {
    private Socket socket;

    public java_33800_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client request here
        // ...

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}