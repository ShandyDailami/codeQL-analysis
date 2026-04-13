import java.io.*;
import java.net.*;

public class java_03275_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message to the client
            dos.writeUTF("Welcome to secure server! Now, please provide username and password to confirm.");

            // Read the username and password from the client
            String username = dis.readUTF();
            String password = dis.readUTF();

            // Check if the provided username and password match the expected values
            if ("expectedUsername".equals(username) && "expectedPassword".equals(password)) {
                dos.writeUTF("Authentication successful!");
            } else {
                dos.writeUTF("Authentication failed!");
           
            }

            dos.close();
            socket.close();
        }
    }
}