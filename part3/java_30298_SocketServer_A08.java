import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30298_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started on port 1234");

            while (true) {
                // Accept a new client
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_30298_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Receive a message from the client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            if (bytesRead < 0) {
                System.out.println("Client disconnected");
                socket.close();
                return;
            }

            // Process the message (e.g., integrity check)
            // This is a very basic example and doesn't include actual security measures
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Message received";
            byte[] responseBytes = response.getBytes();
            socket.getOutputStream().write(responseBytes);
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}