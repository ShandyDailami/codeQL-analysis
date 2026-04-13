import java.io.*;
import java.net.*;

public class java_19614_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is running on port 4444");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Create input stream and output stream
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Receive message from client
            String message = in.readLine();
            System.out.println("Received message from client: " + message);

            // Send response back to client
            out.println("Server response: Message received");
       
            // Close the connection
            socket.close();
        }
    }
}