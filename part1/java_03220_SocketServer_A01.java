import java.io.*;
import java.net.*;

public class java_03220_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a server socket with a specific port.
            serverSocket = new ServerSocket(8189);
            System.out.println("Waiting for client on port 8189...");

            // Accept a new client socket.
            socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create input and output streams.
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read from client.
            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Send back a response.
            String serverMessage = "Hello, client, thanks for connecting!";
            dos.writeUTF(serverMessage);

            // Close the connections.
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}