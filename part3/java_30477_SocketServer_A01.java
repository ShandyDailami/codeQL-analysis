import java.io.*;
import java.net.*;

public class java_30477_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A new client has connected");

            // Send a welcome message
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Welcome to the server!");

            // Listen for a message from the client
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Close the connection
            clientSocket.close();
        }
    }
}