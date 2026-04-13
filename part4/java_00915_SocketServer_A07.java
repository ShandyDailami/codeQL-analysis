import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00915_SocketServer_A07 {

    private static final int PORT = 9001;

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for connection...");

                Socket socket = server.accept();

                System.out.println("Connected to " + socket.getRemoteSocketAddress());

                // Create new thread for each connection
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_00915_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here we can add logic for handling the socket, such as reading from it, writing to it, or other operations

            // For the sake of simplicity, we'll just close the socket here
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}