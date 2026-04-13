import java.io.*;
import java.net.*;

public class java_10614_SocketServer_A03 {

    public static void main(String[] args) throws Exception {

        // Create a socket
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server started on port 6000");

        while (true) {

            // Wait for client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Get client's name
            String clientName = dataInputStream.readUTF();
            System.out.println("Client's name is " + clientName);

            // Send client's name back to client
            dataOutputStream.writeUTF("Hello, " + clientName);

            // Close streams and socket
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        }
    }
}