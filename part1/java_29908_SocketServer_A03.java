import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29908_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a server socket and bind it to a port
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server is running on port 8000");

            // Listen for incoming connections
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a buffered reader to read the request from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Create a print writer to write the response back to the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                // Read the request from the client
                String request = reader.readLine();
                System.out.println("Received request: " + request);

                // Send a response back to the client
                writer.println("Hello, Client!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}