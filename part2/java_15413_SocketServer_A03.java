import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15413_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        // Create a ServerSocket on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        while (true) {
            // Accept a connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create a BufferedReader to read client messages
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create a PrintWriter to write server messages
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // Simulate a security-sensitive operation (e.g., injection)
                String serverMessage = clientMessage.toUpperCase();

                writer.println("Server says: " + serverMessage);
            }

            // Close the socket and reader
            socket.close();
            reader.close();
        }
    }
}