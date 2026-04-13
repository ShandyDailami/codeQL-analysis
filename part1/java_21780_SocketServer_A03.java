import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21780_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Create a new thread for handling the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_21780_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read data from the client
            socket.getInputStream().read();

            // Send a response
            socket.getOutputStream().write("Hello, client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}