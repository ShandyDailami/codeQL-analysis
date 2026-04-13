import java.net.ServerSocket;
import java.net.Socket;

public class java_18172_SocketServer_A07 {
    private static final int PORT = 6666;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_18172_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here
    }
}