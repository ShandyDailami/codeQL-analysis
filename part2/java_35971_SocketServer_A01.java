import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35971_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            // Create a server socket at port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started at port 12345");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Handle client communication in a separate thread
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_35971_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            byte[] bytes = new byte[1024];
            socket.receive(bytes);

            // Process the message (e.g., log it)
            System.out.println("Received message: " + new String(bytes));

            // Send a response back to the client
            socket.send(bytes);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}