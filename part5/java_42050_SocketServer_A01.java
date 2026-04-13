import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_42050_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected: " + socket.getInetAddress().getHostAddress());

                // Create a new thread to handle the communication
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_42050_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle communication here
        // For example, read a message from the client and print it
        try {
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer, "UTF-8");
            System.out.println("Received message: " + message);

            // For the sake of simplicity, we'll simulate a simple echo server
            String response = "Server echo: " + message;
            socket.getOutputStream().write(response.getBytes("UTF-8"));
        } catch (IOException e) {
            System.out.println("Error handling client communication: " + e.getMessage());
        }
    }
}