import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38906_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started on port 1234. Waiting for client...");

            // Accept a new client
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Start a new thread to handle the client
            new Handler(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Handler class for each client connection
class Handler extends Thread {
    private Socket socket;

    public java_38906_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // In a real-world scenario, you'd want to handle multiple client connections
        // and send and receive data to/from the client here
    }
}