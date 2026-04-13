import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_14961_SocketServer_A08 {
    private static final int PORT = 12345;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        try (ServerSocket server = new ServerSocket(PORT, 0, InetAddress.getByName(IP))) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public java_14961_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // You can add code here to handle client communication
            // For instance, you can read data from the client and then send a response back

            // For demonstration purposes, let's assume we received a message from the client
            byte[] received = new byte[1024];
            socket.getInputStream().read(received);
            String message = new String(received, "UTF-8");

            // Send a response back to the client
            String response = "Hello, " + message + "!";
            byte[] responseBytes = response.getBytes("UTF-8");
            socket.getOutputStream().write(responseBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}