import java.io.*;
import java.net.*;

public class java_37752_SocketServer_A01 {

    // Socket server
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            // Create server socket
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is running...");

            while (true) {
                // Accept client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted: " + clientSocket.getInetAddress().getHostAddress());

                // Create input and output stream
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Receive message
                String message = in.readLine();
                System.out.println("Received: " + message);

                // Send response
                out.println("Server: Hello, Client, Your message was: " + message);

                // Close connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}