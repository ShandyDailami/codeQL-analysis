import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35521_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Start a new thread to handle the client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_35521_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the client's request and send a response
            socket.getInputStream().read(); // Simulate reading from the client
            socket.getOutputStream().write(("Hello, client\n").getBytes());
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the connection
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}