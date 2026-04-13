import java.net.*;
import java.io.*;

public class java_11408_SocketServer_A01 {
    public static void main(String[] args) {
        // Create a socket and a socket stream
        Socket socket = null;
        ServerSocket serverSocket = null;

        try {
            // Create a server socket
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            // Wait for a client to connect
            socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create a reader and a writer
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Read a line from the client and write it back
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                writer.println(message);
            }

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}