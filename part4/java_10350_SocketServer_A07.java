import java.io.*;
import java.net.*;

public class java_10350_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String message = dis.readUTF();
            System.out.println("Received message: " + message);

            // Send response back to client
            dos.writeUTF("Server received your message");
            dos.flush();

            // Close connection
            socket.close();
       
        }
    }
}