import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01752_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Handle the client connection in a new thread
                new Handler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
       
        e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private final Socket socket;

    public java_01752_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform security-sensitive operations related to A08_IntegrityFailure
            // ...

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}