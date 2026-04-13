import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26359_SocketServer_A01 {
    private static final int PORT = 9090;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create server socket
            server = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            // Wait for client connection
            socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Create input and output streams
            // This is for sending and receiving data
            // In a real-world scenario, you would probably have a different stream depending on the type of request
            // For example, if the client is sending a file, you might use a FileInputStream and a FileOutputStream
            // If the client is sending a message, you might use a BufferedReader and PrintWriter
            // But for simplicity, we'll use a simple string
            String response = "Hello Client";
            socket.getOutputStream().write(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        //  If an exception occurs, print the error message
        } finally {
            // Always close the connections
            try {
                if (socket != null) socket.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}