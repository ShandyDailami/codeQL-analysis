import java.io.*;
import java.net.*;

public class java_06201_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive message from client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send acknowledgement back to client
            out.writeBytes("ACK\n");

            // Close the streams and the socket connection
            in.close();
            out.close();
            socket.close();
        }
    }
}