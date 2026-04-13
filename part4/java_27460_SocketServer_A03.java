import java.net.*;
import java.io.*;

public class java_27460_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Create input stream and output stream
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Read client message
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Send back a message to the client
            String serverMessage = "Hello, client!";
            dataOutputStream.writeUTF(serverMessage);

            // Close the streams
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        }
    }
}