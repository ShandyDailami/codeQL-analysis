import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41527_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        // Create a server socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_41527_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client socket here
        // For the sake of simplicity, this is just printing the message
        System.out.println("Handling client " + socket.getInetAddress().getHostAddress());
        try {
            // Send a response back to the client
            socket.getOutputStream().write("Hello, client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}