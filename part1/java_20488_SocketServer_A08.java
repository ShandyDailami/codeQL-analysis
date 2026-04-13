import java.net.ServerSocket;
import java.net.Socket;

public class java_20488_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000); // Bind to port 8000
            System.out.println("Server is listening on port 8000...");

            while (true) { // Maintain server running until client connects
                Socket socket = serverSocket.accept(); // Accept client connection
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle client connection and communication here
                // For simplicity, we'll just echo back any received message
                handleClient(socket);
           
                socket.close(); // Close connection
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        // Create input and output streams
        try {
            socket.getInputStream(); // Read input stream
            socket.getOutputStream(); // Write output stream
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // TODO: Implement client communication handling here
        // For simplicity, we'll just echo back any received message
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                socket.getOutputStream().write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}