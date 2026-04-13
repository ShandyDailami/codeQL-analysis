import java.net.*;
import java.io.*;

public class java_29400_SocketServer_A07 {
    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Get the message from the client
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Send the response
            dos.writeUTF("Hello, Client!");
            dos.flush();

            socket.close();
        }
    }
}