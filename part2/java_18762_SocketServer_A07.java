import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18762_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_18762_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);

            // Process the message (e.g., authenticate the client)
            String message = new String(buffer);
            if (!authenticateClient(message)) {
                // If the client is not authenticated, close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean authenticateClient(String message) {
        // Implement authentication here
        // This is a simple example and may not be secure
        // In a real application, you would want to use a secure method for authentication
        return message.equals("secure-message");
    }
}