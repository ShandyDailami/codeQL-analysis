import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_22673_SocketServer_A07 {

    private static final int PORT = 9876;
    private static final int CORE_POOL_SIZE = 2;
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(CORE_POOL_SIZE);

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected");

                // Add a new task to the thread pool to handle the new socket connection
                threadPool.execute(new ClientHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor service when we're done
            threadPool.shutdown();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_22673_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection, including authentication and response
        // This is a simplistic example and should be replaced with actual authentication logic
        try {
            // Receive a message from the client
            String message = socket.getInputStream().readUTF();
            System.out.println("Received message: " + message);

            // Authenticate the client
            // For simplicity, let's assume the authentication is successful
            if (authenticateClient(message)) {
                // If authentication is successful, send a response
                socket.getOutputStream().writeUTF("Authentication successful");
            } else {
                // If authentication is not successful, send an error message
                socket.getOutputStream().writeUTF("Authentication failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This is a placeholder for actual authentication logic
    private boolean authenticateClient(String message) {
        // Here, we're just checking if the message is "admin"
        return message.equals("admin");
    }
}