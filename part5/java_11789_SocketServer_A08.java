import java.io.*;
import java.net.*;

public class java_11789_SocketServer_A08 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create a ServerSocket
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            // Step 2: Accept client connection
            socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Step 3: Send a response to the client
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Connection established");

            // Step 4: Receive request from client
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Step 5: Close the connection
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}