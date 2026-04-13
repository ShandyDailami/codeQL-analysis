import java.io.*;
import java.net.*;

public class java_10421_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8080);
            System.out.println("Waiting for a client...");

            // Accept a client
            socket = server.accept();
            System.out.println("Client connected!");

            // Create an InputStream and OutputStream
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send a message to the client
            dos.writeUTF("Hello client!");

            // Close the connection
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}