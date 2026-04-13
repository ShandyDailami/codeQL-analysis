import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30999_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Handling the client thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_30999_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here you can add code for client's request handling
        // For now, just keep the loop in place
        while (true) {
            // Read the request from client
            // ...
            // ...
            // ...

            // Send the response back to client
            // ...
            // ...
            // ...
        }
    }
}