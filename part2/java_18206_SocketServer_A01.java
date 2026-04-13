import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18206_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        // Creating a server socket
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT + ".");

            while (true) {
                // Listening for a client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted from " + clientSocket.getRemoteSocketAddress());

                // Starting a new thread to handle the client communication
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public java_18206_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Reading the client's message
            byte[] buffer = new byte[1024];
            int bytesRead = clientSocket.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message: " + message);

            // Sending a response
            String response = "Server received your message: " + message;
            clientSocket.getOutputStream().write(response.getBytes());

            // Closing the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}