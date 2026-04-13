import java.io.*;
import java.net.*;

public class java_33208_SocketServer_A07 {

    public static void main(String[] args) throws IOException {

        // Create a socket listener on port 6000
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client...");

        // Accept incoming connection
        Socket socket = server.accept();
        System.out.println("Connected to client!");

        // Create InputStream and OutputStream
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Handle client's input
        String clientInput = dis.readUTF();
        System.out.println("Client says: " + clientInput);

        // Send back a response
        String response = "Hello client, you connected successfully!";
        dos.writeUTF(response);
        System.out.println("Server says: " + response);

        // Close the connection
        socket.close();
    }
}