import java.io.*;
import java.net.*;

public class java_12967_SocketServer_A03 {

    public static void main(String[] args) {
        Socket socket;
        ServerSocket server;

        try {
            // Step 1: Create a ServerSocket and bind it to port 6789
            server = new ServerSocket(6789);
            System.out.println("Server is waiting for connections on port 6789...");

            // Step 2: Accept a connection
            socket = server.accept();
            System.out.println("Connection established with " + socket.getRemoteSocketAddress());

            // Step 3: Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Step 4: Read a line from the client and echo it back
            String message = dis.readUTF();
            System.out.println("Client says: " + message);
            message = message.toUpperCase();
            dos.writeUTF(message);

            // Step 5: Close the streams and the socket
            dos.close();
            dis.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}