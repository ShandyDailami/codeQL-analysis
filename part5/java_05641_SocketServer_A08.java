import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05641_SocketServer_A08 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client connections...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create a new thread for each client connection
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_05641_SocketServer_A08(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Create a new input stream and writer for the client socket
            // This is a basic example. In a real application, you would need to use a more secure way to handle the connection
            // e.g., BufferedReader for reading input, PrintWriter for writing output
            // Also, you might want to handle the exception here
            // ...

            // Send a simple response back to the client
            String response = "Response from server";
            clientSocket.getOutputStream().write(response.getBytes());

            // Close the client socket and the server socket
            // This is a basic example. In a real application, you would need to use a more secure way to handle the connection
            // e.g., clientSocket.close()
            // ...

        } catch (IOException e) {
            e.printStackTrace();
        // Handle exception here if needed
        }
    }
}