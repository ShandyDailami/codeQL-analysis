import java.net.ServerSocket;
import java.net.Socket;

public class java_15875_SocketServer_A07 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Perform authentication here with socket and serverSocket

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_15875_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Perform input and output operations here
            // ...
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}