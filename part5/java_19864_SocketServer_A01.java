import java.io.*;
import java.net.*;

public class java_19864_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read the request from the client
            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // Respond to the client
            String response = "Hello, you connected to the server";
            dos.writeUTF(response);

            // Close the streams
            dos.close();
            dis.close();
       
            // Close the socket
            socket.close();
        }
    }
}