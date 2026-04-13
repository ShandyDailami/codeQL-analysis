import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09808_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Set up the server socket
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started!");

            // Step 2: Wait for client to connect
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");

                // Step 3: Handle the client communication
                // This is a simplified example, real servers should handle multiple clients in a thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while starting the server!");
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_09808_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Step 4: Receive data from the client
            // This is a simplified example, real servers should use a Buffer or similar to handle large amounts of data
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String data = new String(buffer, 0, bytesRead);
            System.out.println("Received: " + data);

            // Step 5: Send response to the client
            // In a real server, you would want to include some kind of authentication or integrity check
            byte[] response = "Server received your message!".getBytes();
            socket.getOutputStream().write(response);
        } catch (IOException e) {
            System.out.println("Error occurred while handling the client!");
            e.printStackTrace();
        }
    }
}