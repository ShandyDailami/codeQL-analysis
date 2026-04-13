import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_05011_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a new server socket
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                // Accept a new client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a reader for the input stream of the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Create a writer for the output stream of the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                // Read a message from the client
                String message = reader.readLine();
                System.out.println("Received message: " + message);

                // Send a response back to the client
                String response = "Server received your message: " + message;
                writer.println(response);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}