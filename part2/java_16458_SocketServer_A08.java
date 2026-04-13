import java.io.*;
import java.net.*;

public class java_16458_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Read the username and password from the client
        String username = in.readUTF();
        String password = in.readUTF();

        // Check if the username and password match (this is just a simple example, in real world you should use a hashing function to securely compare passwords)
        if ("admin".equals(username) && "password".equals(password)) {
            out.writeUTF("Connection successful");
        } else {
            out.writeUTF("Connection failed");
        }

        socket.close();
    }
}