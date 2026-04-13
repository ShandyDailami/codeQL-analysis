import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20093_SocketServer_A08 {
    private static final int PORT = 4445; // Choose an arbitrary unused port

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new PrintWriter to send responses to the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Send a simple message to the client
                out.println("Hello, Client!");

                // Close the connection
                clientSocket.close();
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}