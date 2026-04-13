import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01143_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket at port 8080
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started on port 8080.");

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Create a new thread to handle communication with the client
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_01143_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle communication with the client
        // This is a very basic example and lacks many security-sensitive operations
        // This example assumes the client connects over an insecure connection (TCP port 80)
        // and the client sends a string message to the server
        try {
            // Read the client's message
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            String message = new String(bytes);

            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}