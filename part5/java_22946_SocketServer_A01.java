import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22946_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000); // Listening port
        System.out.println("Server is running and waiting for client connections...");

        while (true) {
            Socket socket = serverSocket.accept(); // Accept a client connection
            System.out.println("A client has connected");

            // Create a new thread for handling communication with the client
            new Thread(() -> handleClient(socket)).start();
        }
    }

    private static void handleClient(Socket socket) {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String message;
            while ((message = in.readLine()) != null) { // Read message from the client
                System.out.println("Received: " + message);
                out.println("Server: " + message); // Send back the received message
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}