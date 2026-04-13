import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13928_SocketServer_A01 {
    private static final int PORT = 12345; // Change this to a different port number

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getInetAddress().getHostAddress());

                // Now, the client can send and receive data.
                // In a real-world scenario, you would use threads for each client, not just one.
                // However, for the sake of simplicity, we'll just use a single thread here.

                // Receive a message from the client
                String received = new String(clientSocket.getInputStream().readNBytes(1024));
                System.out.println("Received: " + received);

                // Send a response back to the client
                String response = "Hello, client!";
                clientSocket.getOutputStream().write(response.getBytes());

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}