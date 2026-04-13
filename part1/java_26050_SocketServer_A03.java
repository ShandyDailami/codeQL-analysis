import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26050_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening for client connections: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public java_26050_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can handle the request from the client
            // e.g., read the request, handle the request, send the response

            // For simplicity, we'll just echo back the received data
            byte[] buffer = new byte[socket.getInputStream().available()];
            socket.getInputStream().read(buffer);
            String request = new String(buffer);

            String response = "Server: Received your message: " + request;
            socket.getOutputStream().write(response.getBytes());

            socket.getOutputStream().flush();
        } catch (IOException e) {
            System.out.println("Error occurred while handling client: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error occurred while closing the client socket: " + e.getMessage());
            }
        }
    }
}