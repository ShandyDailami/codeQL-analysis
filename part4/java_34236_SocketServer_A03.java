import java.io.*;
import java.net.*;

public class java_34236_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a server socket at port 8080
            ServerSocket serverSocket = new ServerSocket(8080);

            System.out.println("Waiting for client connection...");

            // Accept a client socket
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected!");

            // Create input and output streams
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            // Read input from client and send back to client
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Server received: " + inputLine);
            }

            // Close the connection
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}