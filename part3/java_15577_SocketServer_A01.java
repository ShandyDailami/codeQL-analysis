import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15577_SocketServer_A01 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for the new client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_15577_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Perform operations here that are security-sensitive. For example, disallow reading from the client.
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}