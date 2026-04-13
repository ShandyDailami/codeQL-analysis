import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35434_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());

            // Hand over the socket to a new thread for processing
            new Thread(new SocketProcessor(socket)).start();
        }
    }
}

class SocketProcessor implements Runnable {
    private Socket socket;

    public java_35434_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Process the socket here with your own security measures
        // This is just a placeholder, the actual implementation would depend on your specific use case
        System.out.println("Processing request from: " + socket.getRemoteSocketAddress());
    }
}