import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41204_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle each client separately
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_41204_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle each client separately
        try {
            // Create input and output streams
            // Read and write data using these streams
            // Use socket.getInputStream() and socket.getOutputStream()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}