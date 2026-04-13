import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35223_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client request
                new SocketHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error creating server socket: " + e.getMessage());
        }
    }
}

class SocketHandler extends Thread {
    private Socket socket;

    public java_35223_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive message from client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer);
            System.out.println("Received: " + message);

            // Send response back to client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());

        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}