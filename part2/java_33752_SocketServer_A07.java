import java.net.ServerSocket;
import java.net.Socket;

public class java_33752_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 8000; // Change this port number to your liking

        // Create a server socket
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                // Wait for a client to connect
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle the client
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_33752_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle the client's request
        // This is a simplistic example and does not include security-sensitive operations
        // For example, it does not implement authentication
        try {
            // Send a response to the client
            socket.getOutputStream().write("Hello, client!".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}