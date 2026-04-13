import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37977_SocketServer_A08 {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Start new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to bind to port " + PORT);
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_37977_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can add code to handle the client's request.
            // For example, you can read data from the client, verify it and send a response

            // Here is a dummy example. In a real application, you would read a message from the client,
            // verify it's integrity and then send a response.
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String response = "Server received: " + new String(buffer, 0, bytesRead);
            socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}