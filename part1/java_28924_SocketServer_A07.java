import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28924_SocketServer_A07 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started, waiting for client connections...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected, starting communication...");

                // TODO: Add authentication code here

                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private final Socket socket;

    public java_28924_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // TODO: Add client-server communication code here
    }
}