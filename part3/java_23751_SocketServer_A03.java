import java.net.ServerSocket;
import java.net.Socket;

public class java_23751_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread to handle communication with the client
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_23751_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read data from the client
            // This is just a placeholder for security-sensitive operations
            // In a real-world application, data should be read and processed securely
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);

            // This is just a placeholder for security-sensitive operations
            // In a real-world application, data should be sent back to the client
            socket.getOutputStream().write("Hello, client!".getBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}