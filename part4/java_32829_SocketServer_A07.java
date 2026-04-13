import java.io.*;
import java.net.*;

public class java_32829_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is listening on port 6000...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            // Create input stream from socket
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            // Read message from client
            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            // Send response back to client
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Hello, client!");
            dos.flush();

            // Close the connection
            socket.close();
        }
    }
}