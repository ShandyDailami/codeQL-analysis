import java.io.*;
import java.net.*;

public class java_17396_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // Create a ServerSocket and bind it to port 4444
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is running...");
            
            // Accept a client socket
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a buffered reader for the socket input stream
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Create a print writer for the socket output stream
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read from the client and send a response
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("Received: " + response);
                out.println("Server response: " + response);
            }

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}