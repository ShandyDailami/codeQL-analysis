import java.io.*;
import java.net.*;

public class java_05728_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345); // listen on port 12345
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = server.accept(); // wait for client connection
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read username from client
            String username = in.readUTF();
            System.out.println("Received username: " + username);

            // respond with a welcome message
            out.writeUTF("Welcome " + username + "!");
            out.flush();

            socket.close();
        }
    }
}