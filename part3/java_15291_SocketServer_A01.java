import java.io.*;
import java.net.*;

public class java_15291_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create a ServerSocket
            server = new ServerSocket(3333);
            System.out.println("Server is listening on port 3333");

            // Wait for client to connect
            socket = server.accept();
            System.out.println("Client connected");

            // Create an input stream
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            // Read data from client
            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            // Send response to client
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Server says: Hello, Client!");
            dos.flush();

            // Close the streams
            dis.close();
            dos.close();

            // Close the socket
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}