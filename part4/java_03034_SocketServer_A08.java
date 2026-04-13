import java.net.*;
import java.io.*;

public class java_03034_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        // Start the server on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Waiting for client...");

        // Accept incoming connection
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        // Create input and output streams
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        String inputLine;

        // Read from the input stream
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);

            // Send response back to the client
            out.println("Thank you for connecting to " + socket.getRemoteSocketAddress() + "!");
        }

        // Close the connection
        socket.close();
    }
}