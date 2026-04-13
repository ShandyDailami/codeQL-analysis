import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16915_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Start Server
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started");

        while (true) {
            // Listen for client connections
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle client connection
            Handler handler = new Handler(socket);
            handler.start();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_16915_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle client's request
        // ...
    }
}