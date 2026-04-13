import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02327_SocketServer_A01 {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Handle the client in a new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Error accepting connections. Server closing...");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_02327_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can add your security-sensitive operations related to A01_BrokenAccessControl

            // ...

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}