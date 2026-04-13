import java.io.*;
import java.net.*;

public class java_37878_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a socket and bind it to a port
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            // Accept a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a buffered reader for the socket input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read a line from the client
            String line = reader.readLine();
            System.out.println("Received: " + line);

            // If the line does not match a specific pattern (e.g., "IntegrityFailure"), disconnect the client
            if (!line.equals("IntegrityFailure")) {
                socket.close();
                serverSocket.close();
            }

            // If the line matches the pattern, do something else (e.g., send back a response)
            else {
                // Send a response back to the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Server response: IntegrityFailure is a serious security concern");
            }

            // Close the connections
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}