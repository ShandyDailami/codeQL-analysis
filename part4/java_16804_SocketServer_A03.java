import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16804_SocketServer_A03 {

    private static final int PORT = 12345; // Define the port here

    public static void main(String[] args) {
        ServerSocket server = null; // Declare the ServerSocket
        Socket socket = null; // Declare the Socket

        try {
            // Create the ServerSocket
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) { // Main server loop
                // Accept incoming connection
                socket = server.accept();
                System.out.println("New connection accepted from: " + socket.getRemoteSocketAddress());

                // Create a new thread to handle the communication
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close(); // Close the server
                if (socket != null) socket.close(); // Close the socket
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_16804_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the communication here
        // For simplicity, this method does nothing but can be used for real-world use cases
    }
}