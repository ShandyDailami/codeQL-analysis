import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37339_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected");

                // Use a thread for each client to handle multiple connections
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_37339_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here we can add code that handles the communication with the client
            // For example, we can read a message from the client and print it
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            System.out.println("Received message: " + new String(buffer));

            // Respond to the client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());

        } catch (IOException e) {
            System.out.println("Client handler error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}