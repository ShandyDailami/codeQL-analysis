import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08851_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
            }
        } catch (IOException e) {
            System.out.println("Error establishing a connection to the client.");
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public java_08851_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Simulate sending a message to the client
            String response = "Hello, client!";
            clientSocket.getOutputStream().write(response.getBytes());

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error handling the client connection.");
            e.printStackTrace();
        }
    }
}