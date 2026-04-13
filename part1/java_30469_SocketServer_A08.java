import java.io.*;
import java.net.*;

public class java_30469_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Creating a server socket
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept(); // Accepting a connection
            System.out.println("Client connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String request = reader.readLine(); // Reading the client's request
            System.out.println("Received: " + request);

            // Here, we simulate the client's request as the actual client's response
            String response = "Your response was correct";

            // Checking the integrity of the request
            if (request.equals("Your specific request")) {
                // Checking the integrity of the response
                if (response.equals("Your specific response")) {
                    writer.writeBytes("IntegrityFailureException\n"); // If both are correct, throw an exception
                    throw new IntegrityFailureException("IntegrityFailureException"); // Throw an exception
                } else {
                    writer.writeBytes("Invalid response\n"); // If the response is incorrect, write an error message
                }
            } else {
                writer.writeBytes("Invalid request\n"); // If the request is incorrect, write an error message
            }

            writer.flush(); // Flush the output buffer to send the response back to the client
            socket.close(); // Close the connection
        }
    }
}