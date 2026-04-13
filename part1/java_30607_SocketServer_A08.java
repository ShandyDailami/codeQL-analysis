import java.io.*;
import java.net.*;

public class java_30607_SocketServer_A08 {

    public static void main(String[] args) {
        Socket socket;
        ServerSocket serverSocket;
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;

        try {
            // Create a ServerSocket on a port
            serverSocket = new ServerSocket(4444);
            System.out.println("Waiting for a connection...");

            // Wait for a connection
            socket = serverSocket.accept();
            System.out.println("Connection established!");

            // Get Input and Output Streams
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Read from the client
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Send a response
            String serverMessage = "Hello client, you connected!";
            dataOutputStream.writeUTF(serverMessage);

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}