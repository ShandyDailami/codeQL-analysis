import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23555_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_23555_SocketServer_A03(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Receive the message from the client
            String message = clientSocket.getInputStream().readUTF();
            System.out.println("Received message: " + message);

            // Process the message (e.g., perform some security-sensitive operation)
            processMessage(message);

            // Send a response back to the client
            clientSocket.getOutputStream().writeUTF("Message received");
            System.out.println("Sent message: Message received");

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processMessage(String message) {
        // Implement your security-sensitive operation here (e.g., use a password hasher)
        // This is just a placeholder, replace it with your actual implementation
        // ...
    }
}