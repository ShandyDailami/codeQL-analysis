import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33832_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server on port 12345: " + e.getMessage());
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_33832_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Here you can add code to handle client communication, including reading and writing
        // However, for the purposes of this example, we'll just print out the client's message
        try {
            // Read the message from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer, "UTF-8");
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            byte[] responseBytes = response.getBytes("UTF-8");
            socket.getOutputStream().write(responseBytes);
            socket.getOutputStream().flush();

        } catch (IOException e) {
            System.err.println("Failed to handle client: " + e.getMessage());
        }
    }
}