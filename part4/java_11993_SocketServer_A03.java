import java.io.*;
import java.net.*;

public class java_11993_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            // Create stream for communication
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read and echo the message
            String message = in.readUTF();
            System.out.println("Message received: " + message);
            out.writeUTF("Echo: " + message);
            out.flush();

            // Close the streams
            in.close();
            out.close();
            client.close();
       
        }
    }
}