import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18624_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Handle client connection in a new thread
            new HandlerThread(socket).start();
        }
    }
}

class HandlerThread extends Thread {
    private final Socket socket;

    public java_18624_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client request here
    }
}