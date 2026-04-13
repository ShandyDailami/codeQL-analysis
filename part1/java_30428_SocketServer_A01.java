import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30428_SocketServer_A01 {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("IOException occurred while trying to listen on port " + PORT);
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_30428_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here, we simulate a broken access control by allowing all incoming client data
            socket.getInputStream().read();
        } catch (IOException e) {
            System.err.println("IOException occurred while reading from socket");
            e.printStackTrace();
        }
    }
}