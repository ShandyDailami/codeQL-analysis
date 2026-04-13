import java.io.*;
import java.net.*;

public class java_35471_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000); // Assuming port 6000 is free
        System.out.println("Server is waiting for client connection... ");

        Socket socket = serverSocket.accept(); // waiting for client connection
        System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        // Receive request from client
        String request = dataInputStream.readUTF();
        System.out.println("Received: " + request);

        // Send response to client
        String response = "Hello client, you connected successfully.";
        dataOutputStream.writeUTF(response);

        // Close connection
        socket.close();
        serverSocket.close();
    }
}