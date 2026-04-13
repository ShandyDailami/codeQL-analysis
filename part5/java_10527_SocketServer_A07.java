import java.io.*;
import java.net.*;

public class java_10527_SocketServer_A07 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create a server socket on port 9000
            serverSocket = new ServerSocket(9000);
            System.out.println("Server is listening on port 9000");

            // Step 2: Wait for a client to connect
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Send a welcome message to the client
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Welcome to the server!");

            // Step 4: Handle the client input
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String clientMessage = inputStream.readUTF();
            System.out.println("Client said: " + clientMessage);

            // Step 5: Close the connection
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}