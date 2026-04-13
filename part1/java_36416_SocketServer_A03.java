import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36416_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            // Accept a client socket
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Get input and output streams
            OutputStream outputStream = clientSocket.getOutputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Send a message to the client
            outputStream.write("Hello, Client!".getBytes());

            // Receive a message from the client
            String message = input.readLine();
            System.out.println("Message from client: " + message);

            // Close the connection
            clientSocket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}