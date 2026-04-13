import java.io.*;
import java.net.*;

public class java_23570_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8000);

        while (true) {
            Socket socket = server.accept();

            // Create streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read request
            String request = input.readUTF();
            System.out.println("Client says: " + request);

            // Send response
            String response = "Hello, client!";
            output.writeUTF(response);

            // Close the connection
            socket.close();
        }
    }
}