import java.net.*;
import java.io.*;

public class java_41134_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Waiting for client...");

        // Accept a connection
        Socket socket = server.accept();
        System.out.println("Connected!");

        // Create input and output streams
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Send a welcome message to the client
        out.println("Welcome to the server!");

        // Read and echo the client's messages
        String clientMessage;
        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Received: " + clientMessage);
            out.println("Echo: " + clientMessage);
        }

        // Close the connection
        socket.close();
        server.close();
    }
}