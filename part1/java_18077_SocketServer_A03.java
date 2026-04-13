import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18077_SocketServer_A03 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT + "...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");

                new SocketServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketServerThread extends Thread {

    private final Socket socket;

    public java_18077_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform operations related to A03_Injection here.
            // For example, reading from the socket, processing data, etc.

            // Close the socket here.
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}