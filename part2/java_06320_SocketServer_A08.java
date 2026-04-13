import java.net.*;
import java.io.*;

public class java_06320_SocketServer_A08 {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");
            
            while(true) {
                Socket socket = server.accept();
                System.out.println("A client has connected");

                // Create data streams for reading and writing
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read message from client
                String message = in.readLine();
                System.out.println("Client says: " + message);

                // Send back a response
                String response = "Server says: Hello, client!";
                out.writeBytes(response + "\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}