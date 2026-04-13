import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26013_SocketServer_A01 {
    private static final int PORT = 4445; // Change to a port number you want to use.

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here, we're assuming that the client sends a simple "Hello, World!" message.
                // In a real-world application, you would probably want to handle multiple messages at once, 
                // possibly with a message handler thread.
                String message = new String(socket.getInputStream().readNBytes(1024));
                System.out.println("Received: " + message);

                // Send a simple "Hello, World!" message back to the client.
                socket.getOutputStream().write("Hello, World!".getBytes());
                socket.getOutputStream().flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}