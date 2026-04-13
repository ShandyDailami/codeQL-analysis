import java.net.*;
import java.io.*;

public class java_13419_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a server socket at port 8000
            serverSocket = new ServerSocket(8000);
            System.out.println("Waiting for client...");

            // Accept a client
            socket = serverSocket.accept();
            System.out.println("Connected with " + socket.getRemoteSocketAddress());

            // Create an input stream
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            // Read from the input stream
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Write to the output stream
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress());

            // Close the connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}