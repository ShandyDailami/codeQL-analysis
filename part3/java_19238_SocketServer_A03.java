import java.io.*;
import java.net.*;

public class java_19238_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is listening on port 5000");
        
        while (true) {
            Socket socket = server.accept();
            
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Get the client's message
            String clientMessage = in.readLine();
            System.out.println("Received: " + clientMessage);

            // Send the server's message
            String serverMessage = "Hello, Client!";
            out.writeBytes(serverMessage + "\n");

            // Close the socket
            socket.close();
        }
    }
}