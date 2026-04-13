import java.io.*;
import java.net.*;

public class java_03869_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            // Create streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Handle client requests
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            out.writeUTF("Message received");
            out.flush();

            socket.close();
        }
    }
}