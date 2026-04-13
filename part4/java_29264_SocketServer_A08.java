import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29264_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to bind server on port " + PORT);
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_29264_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client request and response here
        // For simplicity, we'll just simulate a failure by throwing an exception
        try {
            socket.getInputStream().read();
            socket.getOutputStream().write(0xFF);
        } catch (IOException e) {
            // Here you could handle the integrity failure scenario
            // For example, you might want to log the error and close the connection
            // or you might want to reconnect the client
            e.printStackTrace();
        }
    }
}