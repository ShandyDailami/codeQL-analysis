import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05110_SocketServer_A01 {

    private static final int PORT = 4000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle the client connection in a new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server on port " + PORT);
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_05110_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // TODO: Implement client handling logic here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}