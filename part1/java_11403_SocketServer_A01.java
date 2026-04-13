import java.io.*;
import java.net.*;

public class java_11403_SocketServer_A01 {

    public static void main(String[] args) throws Exception {

        // Step 1: Create a server socket.
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080...");

        // Step 2: Accept a client socket.
        Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected!");

        // Step 3: Get input and output streams.
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;

        // Step 4: Read client input and send back server response.
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);

            String response = inputLine.toUpperCase();

            out.println("Server response: " + response);
        }

        // Close the connection.
        clientSocket.close();
        serverSocket.close();
    }
}