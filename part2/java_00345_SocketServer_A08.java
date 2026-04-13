import java.io.*;
import java.net.*;

public class java_00345_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();

            // Create streams for reading and writing
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            out.writeUTF(response);
            out.flush();

            // Close the streams
            socket.close();
        }
    }
}