import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29204_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");

                // Handle the socket connection in a separate thread
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_29204_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection here
        // For simplicity, we're not implementing security-sensitive operations
    }
}