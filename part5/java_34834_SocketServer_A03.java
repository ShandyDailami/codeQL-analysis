import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34834_SocketServer_A03 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start: " + e.getMessage());
       
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_34834_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection here
    }
}