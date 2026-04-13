import java.io.*;
import java.net.*;

public class java_29449_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            Socket socket = serverSocket.accept();

            // Create streams
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Create and send a message to client
            String message = "Hello, client!";
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

            // Read the message from the client
            String response = dataInputStream.readUTF();
            System.out.println("Server received: " + response);

            // Close the connection
            socket.close();
        }
    }
}