import java.io.*;
import java.net.*;

public class java_05866_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);

        System.out.println("Server is running and waiting for a client to connect...");

        Socket socket = serverSocket.accept();

        System.out.println("Client connected!");

        // Read from the client
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message, response;

        // Continuously read client messages and send back a response
        while ((message = in.readLine()) != null) {
            System.out.println("Client says: " + message);
            response = "Server says: " + message;
            out.println(response);
        }

        // Close the connection
        socket.close();
        serverSocket.close();
    }
}