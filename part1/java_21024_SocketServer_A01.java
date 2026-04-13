import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21024_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Handling the client connection in a separate thread
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_21024_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Handle client requests here
            // This is a placeholder and does not involve any security-sensitive operations
            // You can remove this placeholder and add your own security-sensitive operations
            socket.getInputStream().read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}