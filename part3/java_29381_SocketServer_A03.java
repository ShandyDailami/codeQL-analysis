import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29381_SocketServer_A03 {

    // Main server function
    public static void main(String[] args) throws IOException {
        // Create a server socket and bind it to a port
        ServerSocket serverSocket = new ServerSocket(8080);

        // Main server loop
        while (true) {
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();

            // Create a new thread to handle the client
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}

// ClientHandler class
class ClientHandler implements Runnable {

    private Socket socket;

    // Constructor
    public java_29381_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    // Run method for the thread
    @Override
    public void run() {
        try {
            // Receive a message from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer);

            // Process the message
            processMessage(message);

            // Send a response back to the client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Process the message, this is where we implement our security measures
    private void processMessage(String message) {
        // Check for injection attacks
        if (message.contains("injection")) {
            System.out.println("Injection attack detected!");
        }
    }
}