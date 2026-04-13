import java.net.*;
import java.io.*;

public class java_40793_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Waiting for client...");

        // Accept a new client
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Create input and output streams
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Read a message from the client
        String message = dis.readUTF();
        System.out.println("Received: " + message);

        // Echo the message back to the client
        dos.writeUTF("Echo: " + message);
        dos.flush();

        // Close the connection
        socket.close();
   
        // Server is stopped
        serverSocket.close();
    }
}