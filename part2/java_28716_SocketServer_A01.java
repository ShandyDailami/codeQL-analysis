import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28716_SocketServer_A01 {
    private static final int PORT = 9876; // Choose a port number

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT); // Create server socket

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept(); // Accept client connection

            // Here is the vulnerable part, the client is not checked for access control
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Start a new thread to handle communication with the client
            new HandleClientThread(clientSocket).start();
        }
    }
}

class HandleClientThread extends Thread {
    private final Socket clientSocket;

    public java_28716_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // Here is where you can add code to handle client communication
        // The code is not security-sensitive, it just reads data from the client

        // You can add a try-catch block to handle any exceptions
        try {
            // Read data from client
            byte[] buffer = new byte[1024];
            int bytesRead = clientSocket.getInputStream().read(buffer);
            String data = new String(buffer, 0, bytesRead);

            // Print received data
            System.out.println("Received: " + data);

            // Send a response to client
            String response = "Hello, client!";
            clientSocket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}