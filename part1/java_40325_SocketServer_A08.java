import java.io.*;
import java.net.*;

public class java_40325_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Waiting for client connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a data input stream and output stream for the socket
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Read a message from the client
            String message = dataInputStream.readUTF();
            System.out.println("Client said: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            dataOutputStream.writeUTF(response);

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}