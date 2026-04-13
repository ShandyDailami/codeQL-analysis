import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07891_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create new thread for each client connection
                new Thread(new SocketHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private final Socket socket;

    public java_07891_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform integrity failure check (this is a placeholder for a real check)
            if (socket.getInputStream().read() != socket.getOutputStream().write(42)) {
                System.out.println("Integrity failure detected!");
                socket.close();
            } else {
                System.out.println("No integrity failures detected!");
            }
        } catch (IOException e) {
            System.out.println("Failed to handle socket: " + e.getMessage());
            socket.close();
        }
    }
}