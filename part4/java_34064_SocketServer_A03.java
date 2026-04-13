import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34064_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started. Waiting for client connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Create a new thread for each client connection
            new Thread(new SocketHandler(socket)).start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_34064_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Code here for handling the socket connection
    }
}